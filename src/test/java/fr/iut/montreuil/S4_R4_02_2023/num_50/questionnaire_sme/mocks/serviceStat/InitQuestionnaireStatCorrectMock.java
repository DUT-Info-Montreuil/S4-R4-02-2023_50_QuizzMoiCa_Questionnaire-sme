package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.serviceStat;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionnaireStatistique;

public class InitQuestionnaireStatCorrectMock implements InterfaceQuestionnaireStatistique {
    public int nbJouer = 0;



    @Override
    public void incrementNbrFoisJouer() {
    }

    public int getNbJouer() {
        return nbJouer;
    }
}
