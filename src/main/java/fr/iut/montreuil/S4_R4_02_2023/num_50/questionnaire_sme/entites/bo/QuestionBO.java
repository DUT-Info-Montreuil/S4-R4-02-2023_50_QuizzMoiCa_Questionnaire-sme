package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.enums.Difficulty;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.enums.Langue;

public class QuestionBO {
    private int numQuestion;
    private Langue langues;
    private String libelleQuestion;
    private String reponse;
    private Difficulty difficulty;
    private String explication;
    private String source;

    public QuestionBO(int numQuestion, Langue langues, String libelleQuestion, String reponse, Difficulty difficulty, String explication, String source) {
        this.numQuestion = numQuestion;
        this.langues = langues;
        this.libelleQuestion = libelleQuestion;
        this.reponse = reponse;
        this.difficulty = difficulty;
        this.explication = explication;
        this.source = source;
    }

    public String getLibelleQuestion() {
        return libelleQuestion;
    }
}
