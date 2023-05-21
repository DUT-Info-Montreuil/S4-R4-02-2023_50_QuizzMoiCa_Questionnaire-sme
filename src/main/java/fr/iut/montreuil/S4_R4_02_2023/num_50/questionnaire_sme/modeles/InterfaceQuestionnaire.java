package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles;


import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.*;

import java.net.URI;


public interface InterfaceQuestionnaire {

    public QuestionnaireBO chargerFileQuestionnaire(URI path)throws FileNoteFoundExeption, ErrorWhileLoadingException, QuestionnaireEmptyException, DoubleQuestionException,WrongFileTypeException;
}
