package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.serviceStat;


import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionStatistique;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.QuestionPasJouerException;

public class IncrementNbrFoisJouerQuestionCorrectMock implements InterfaceQuestionStatistique {

     public int nbJouer = 0;

    @Override
    public void incrementNbrFoisJouer() {
        nbJouer++;
    }

    @Override
    public void incrementNbrFoisReussi() {

    }



    @Override
    public double getStatistiqueReussi() throws QuestionPasJouerException {
        return 0;
    }
}
