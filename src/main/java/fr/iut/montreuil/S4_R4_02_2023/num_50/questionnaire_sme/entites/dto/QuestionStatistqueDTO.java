package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.dto;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.QuestionPasJouerException;

public class QuestionStatistqueDTO {

    int nbRate;
    int nbReussi;

    public QuestionStatistqueDTO(){
        nbRate = 0;
        nbReussi = 0;
    }
    public void incrementNbrFoisRate(){
        nbRate++;
    }

    public void incrementNbrFoisReussi(){
        nbReussi++;
    }

    public double getStatistiqueReussi() throws QuestionPasJouerException {
        if (nbRate+nbReussi == 0)
            throw new QuestionPasJouerException();
        return (double) nbReussi/(nbRate+nbReussi);
    }

    public int getNbFoisPoser(){
        return (nbRate+nbReussi);
    }
}
