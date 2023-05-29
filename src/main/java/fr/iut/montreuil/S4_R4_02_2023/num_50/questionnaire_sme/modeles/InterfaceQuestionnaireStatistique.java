package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.NoSatistiqueFoundException;

public interface InterfaceQuestionnaireStatistique {

    public void  incrementNbrFoisJouer() throws  NoSatistiqueFoundException;
}