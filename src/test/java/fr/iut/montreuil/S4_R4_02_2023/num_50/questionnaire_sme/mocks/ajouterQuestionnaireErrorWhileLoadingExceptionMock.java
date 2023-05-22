package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionnaire;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.*;

import java.net.URI;

public class ajouterQuestionnaireErrorWhileLoadingExceptionMock implements InterfaceQuestionnaire {


    @Override
    public QuestionnaireBO chargerFileQuestionnaire(URI path) throws FileNoteFoundExeption, ErrorWhileLoadingException, QuestionnaireEmptyException, DoubleQuestionException, WrongFileTypeException {
        throw new ErrorWhileLoadingException();
    }
}
