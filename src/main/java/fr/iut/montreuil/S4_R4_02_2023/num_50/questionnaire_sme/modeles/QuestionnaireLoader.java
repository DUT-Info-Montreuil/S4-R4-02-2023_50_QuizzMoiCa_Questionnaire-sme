package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.enums.Difficulty;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.enums.Langue;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.*;


import com.opencsv.CSVReader;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

public class QuestionnaireLoader implements InterfaceQuestionnaire {
    @Override
    public QuestionnaireBO chargerFileQuestionnaire(URI path) throws FileNoteFoundExeption, ErrorWhileLoadingException, QuestionnaireEmptyException, DoubleQuestionException, WrongFileTypeException, IncompleteQuestionException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNoteFoundExeption();
        }
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (!extension.equals("csv")) {
            throw new WrongFileTypeException();
        }

        ArrayList<QuestionBO> questions = new ArrayList<>();

        try {
            CSVReader reader = new CSVReader(new java.io.FileReader(file));
            String[] nextLine;
            int idQuestionnaire = 0;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length != 8) {
                    throw new IncompleteQuestionException();
                }
                idQuestionnaire = Integer.parseInt(nextLine[0]);
                int numQuestion = Integer.parseInt(nextLine[1]);
                Langue langue = Langue.valueOf(nextLine[2]);
                String libelleQuestion = nextLine[3];
                String reponse = nextLine[4];
                Difficulty difficulty = Difficulty.valueOf(nextLine[5]);
                String explication = nextLine[6];
                String source = nextLine[7];

                if (existeQuestionAvecLibelle(questions, libelleQuestion)) {
                    throw new DoubleQuestionException();
                }
                QuestionBO question = new QuestionBO(numQuestion, langue, libelleQuestion, reponse, difficulty, explication, source);
                questions.add(question);
            }

            if (questions.isEmpty()) {
               throw new QuestionnaireEmptyException();
            }
            return new QuestionnaireBO(idQuestionnaire, questions);

        } catch (Exception e) {
            throw new ErrorWhileLoadingException();
        }
    }

    private boolean existeQuestionAvecLibelle(ArrayList<QuestionBO> questions, String libelle) {
        for (QuestionBO question : questions) {
            if (question.getLibelleQuestion().equals(libelle)) {
                return true;
            }
        }
        return false;
    }
}
