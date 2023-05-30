package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.serviceStat;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionStatistique;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.QuestionPasJouerException;

public class GetStatistiqueReussiQuestionPasJouerExceptionMock implements InterfaceQuestionStatistique {
    @Override
    public void incrementNbrFoisReussi() {

    }

    @Override
    public void incrementNbrFoisJouer() {

    }

    @Override
    public double getStatistiqueReussi() throws QuestionPasJouerException {
        throw new QuestionPasJouerException();
    }
}

