package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.serviceStat;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionStatistique;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.QuestionPasJouerException;

public class IncrementReussiQuestionCorrectMock implements InterfaceQuestionStatistique {


    public int nbReussi = 0;


    @Override
    public void incrementNbrFoisReussi() {
        nbReussi++;
    }

    @Override
    public void incrementNbrFoisJouer() {

    }

    @Override
    public double getStatistiqueReussi() throws QuestionPasJouerException {
        return 0;
    }
}
