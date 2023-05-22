package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.*;

import java.net.URI;

public class ajouterQuestionnaireIncompleteQuestionExceptionMock {

    @Override
    public QuestionnaireBO chargerFileQuestionnaire(URI path) throws FileNoteFoundExeption, ErrorWhileLoadingException, QuestionnaireEmptyException, DoubleQuestionException, WrongFileTypeException {
        return new IncompleteQuestionException();
    }
}
