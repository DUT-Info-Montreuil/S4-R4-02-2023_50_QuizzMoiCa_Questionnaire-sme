package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.dto;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.enums.Difficulty;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.enums.Langue;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.QuestionPasJouerException;

public class QuestionDTO {

    private int numQuestion;
    private Langue langues;
    private String libelleQuestion;
    private String reponse;
    private Difficulty difficulty;
    private String explication;
    private String source;
    private QuestionStatistqueDTO statQuestion;

    public QuestionDTO(QuestionBO questionBO) {
        this.numQuestion = questionBO.getNumQuestion();
        this.langues = questionBO.getLangues();
        this.libelleQuestion = questionBO.getLibelleQuestion();
        this.reponse = questionBO.getReponse();
        this.difficulty = questionBO.getDifficulty();
        this.explication = questionBO.getExplication();
        this.source = questionBO.getSource();
        this.statQuestion = new QuestionStatistqueDTO();
    }

    public QuestionStatistqueDTO getStatQuestion() throws QuestionPasJouerException {
        return statQuestion;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

}
