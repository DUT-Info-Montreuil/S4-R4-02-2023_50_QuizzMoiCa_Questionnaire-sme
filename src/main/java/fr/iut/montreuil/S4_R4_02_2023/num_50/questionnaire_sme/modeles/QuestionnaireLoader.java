package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.enums.Difficulty;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.enums.Langue;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionnaireLoader implements InterfaceQuestionnaire {
    @Override
    public QuestionnaireBO chargerFileQuestionnaire(URI path) throws FileNoteFoundExeption, ErrorWhileLoadingException, QuestionnaireEmptyException, DoubleQuestionException, WrongFileTypeException, IncompleteQuestionException {

        File file = new File(path.getPath());
        if (!file.exists()) {
            throw new FileNoteFoundExeption();
        }

        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (!extension.equals("csv")) {
            throw new WrongFileTypeException();
        }

        ArrayList<QuestionBO> questions = new ArrayList<>();
// try and catch file not found

        try {
            CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader reader = new CSVReaderBuilder(new java.io.FileReader(file)).withCSVParser(csvParser).build();
            ArrayList<String[]> allData = new ArrayList<>(reader.readAll());
            int idQuestionnaire = 0;
            Difficulty difficulty = null;


            //verifier si le fichier est vide
            if (allData.size() <=1 && allData.get(0).length <= 1) {
                throw new QuestionnaireEmptyException();
            }


            for (String[] line : allData) {
                line[0] = line[0].replace("\uFEFF", "").trim();
                if (line.length != 8) {
                    throw new IncompleteQuestionException();
                } else {
                    idQuestionnaire = Integer.parseInt(line[0]);
                    int numQuestion = Integer.parseInt(line[1]);
                    Langue langue = Langue.valueOf(line[2]);
                    String libelleQuestion = line[3];
                    String reponse = line[4];
                    switch (Integer.parseInt(line[5])) {
                        case 1:
                            difficulty = Difficulty.EASY;
                            break;
                        case 2:
                            difficulty = Difficulty.MEDIUM;
                            break;
                        case 3:
                            difficulty = Difficulty.HARD;
                            break;
                    }
                    String explication = line[6];
                    String source = line[7];

                    if (existeQuestionAvecLibelle(questions, libelleQuestion)) {
                        throw new DoubleQuestionException();
                    }
                    QuestionBO question = new QuestionBO(numQuestion, langue, libelleQuestion, reponse, difficulty, explication, source);
                    questions.add(question);
                }
            }
            return new QuestionnaireBO(idQuestionnaire, questions);
        } catch (QuestionnaireEmptyException | IncompleteQuestionException | DoubleQuestionException e) {
            // Traiter les exceptions spécifiques que vous avez lancées
            throw e;
        } catch (Exception exception) {
            // Capturer toutes les autres exceptions
            throw new ErrorWhileLoadingException();
            //
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
