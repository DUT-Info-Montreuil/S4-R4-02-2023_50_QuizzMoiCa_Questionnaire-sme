package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.dto;

public class QuestionnaireStatistqueDTO {

    int nbJouer;


    public QuestionnaireStatistqueDTO(){
        nbJouer = 0;
    }

    public void  incrementNbrFoisJouer(){
        nbJouer++;
    }

    public int getNbJouer() {
        return nbJouer;
    }
}
