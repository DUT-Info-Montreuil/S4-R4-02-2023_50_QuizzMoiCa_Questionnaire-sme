package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.dto;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.enums.Difficulty;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.PasDeQuestionException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.QuestionPasJouerException;

import java.util.ArrayList;

public class QuestionnaireDTO {

    private int idQuestionnaire;
    private QuestionnaireStatistqueDTO statQuestionnaire;
    ArrayList<QuestionDTO> questionsDTO;

    public QuestionnaireDTO(QuestionnaireBO questionnaireBo) {
        this.idQuestionnaire = questionnaireBo.getIdQuestionnaire();
        this.questionsDTO = boToDto(questionnaireBo.getQuestions());
        this.statQuestionnaire = new QuestionnaireStatistqueDTO();
    }

    private ArrayList<QuestionDTO> boToDto(ArrayList<QuestionBO> questionnaireBo){

        ArrayList<QuestionDTO> questionnaireDTO = new ArrayList<>();

        for (QuestionBO questionBO:questionnaireBo)
            questionnaireDTO.add(new QuestionDTO(questionBO));

        return questionnaireDTO;
    }

    public int getNbFoisQuestionnaireJoue(){
        return statQuestionnaire.getNbJouer();
    }

    public QuestionDTO QuestionMeilleurStatistiques() throws PasDeQuestionException, QuestionPasJouerException {
        if(questionsDTO.size() == 0)
            throw new PasDeQuestionException();

        QuestionDTO questionDTO = questionsDTO.get(0);

        for(QuestionDTO question: questionsDTO){
            if (question.getStatQuestion().getStatistiqueReussi() > questionDTO.getStatQuestion().getStatistiqueReussi())
                questionDTO = question;
            else if (question.getStatQuestion().getStatistiqueReussi() == questionDTO.getStatQuestion().getStatistiqueReussi())
                if (question.getDifficulty() == questionDTO.getDifficulty())
                    if(question.getStatQuestion().getNbFoisPoser() > questionDTO.getStatQuestion().getNbFoisPoser())
                        questionDTO = question;
                else if (((question.getDifficulty() == Difficulty.HARD) & questionDTO.getDifficulty() == Difficulty.MEDIUM || questionDTO.getDifficulty() == Difficulty.EASY) || (question.getDifficulty() == Difficulty.MEDIUM & questionDTO.getDifficulty() == Difficulty.EASY));
                    questionDTO = question;
        }

        return questionDTO;
    }

    public QuestionDTO QuestionPireStatistiques() throws PasDeQuestionException, QuestionPasJouerException {
        if(questionsDTO.size() == 0)
            throw new PasDeQuestionException();

        QuestionDTO questionDTO = questionsDTO.get(0);

        for(QuestionDTO question: questionsDTO){
            if (question.getStatQuestion().getStatistiqueReussi() > questionDTO.getStatQuestion().getStatistiqueReussi())
                questionDTO = question;
            else if (question.getStatQuestion().getStatistiqueReussi() == questionDTO.getStatQuestion().getStatistiqueReussi())
                if (question.getDifficulty() == questionDTO.getDifficulty())
                    if(question.getStatQuestion().getNbFoisPoser() > questionDTO.getStatQuestion().getNbFoisPoser())
                        questionDTO = question;
                    else if (((question.getDifficulty() == Difficulty.EASY) & questionDTO.getDifficulty() == Difficulty.MEDIUM || questionDTO.getDifficulty() == Difficulty.HARD) || (question.getDifficulty() == Difficulty.EASY && questionDTO.getDifficulty() == Difficulty.MEDIUM));
            questionDTO = question;
        }

        return questionDTO;
    }
}
