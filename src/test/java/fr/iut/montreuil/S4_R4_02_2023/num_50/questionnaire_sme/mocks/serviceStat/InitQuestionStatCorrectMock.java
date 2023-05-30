package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.serviceStat;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionStatistique;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.QuestionPasJouerException;

public class InitQuestionStatCorrectMock implements InterfaceQuestionStatistique {
    public int nbRate = 0;
   public int nbReussi = 0;

    @Override
    public void incrementNbrFoisReussi() {

    }

    @Override
    public void incrementNbrFoisRate() {

    }

    @Override
    public double getStatistiqueReussi() throws QuestionPasJouerException {
        return 0;
    }

    public int getNbRate() {
        return nbRate;
    }

    public int getNbReussi() {
        return nbReussi;
    }
}
