package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.NoSatistiqueFoundException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.QuestionPasJouerException;

public interface InterfaceQuestionStatistique {

    public void  incrementNbrFoisReussi() throws NoSatistiqueFoundException;
    public void  incrementNbrFoisRate() throws NoSatistiqueFoundException;
    public double getStatistiqueReussi() throws NoSatistiqueFoundException, QuestionPasJouerException;

}
