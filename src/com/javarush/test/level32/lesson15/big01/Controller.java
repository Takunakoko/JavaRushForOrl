package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by admin on 29.03.2016.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view)
    {
        this.view = view;
    }

    public void init()
    {
        createNewDocument();
    }

    public void exit()
    {
        System.exit(0);
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);

        view.init();
        controller.init();
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void resetDocument()
    {
        if (document != null)
        {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text)
    {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try
        {
            new HTMLEditorKit().read(stringReader, document, 0);
        }
        catch (Exception e)
        {
            new ExceptionHandler().log(e);
        }
    }

    public String getPlainText()
    {
        StringWriter stringWriter = new StringWriter();
        try
        {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        }catch (Exception e)
        {
            new ExceptionHandler().log(e);
        }
        return stringWriter.toString();
    }


    public void createNewDocument() {
        //Выбирать html вкладку у представления
        view.selectHtmlTab();
        //Сбрасывать текущий документ
        resetDocument();
        //Устанавливать новый заголовок окна
        view.setTitle("HTML редактор");
        //Сбрасывать правки в Undo менеджере
        view.resetUndo();
        //Обнулить переменную currentFile
        currentFile = null;
    }

    public void openDocument()
    {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int returnValue = fileChooser.showOpenDialog(view);
        if(returnValue == fileChooser.APPROVE_OPTION)
        {
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader fileReader = new FileReader(currentFile))
            {
                new HTMLEditorKit().read(fileReader, document, 0);
            }
            catch (Exception e)
            {
                new ExceptionHandler().log(e);
            }
            view.resetUndo();
        }
    }

    public void saveDocument()
    {
        if(currentFile == null)
            saveDocumentAs();
        else
        {
            view.selectHtmlTab();

            try (FileWriter fileWriter = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e)
            {
                new ExceptionHandler().log(e);
            }
        }
    }


    public void saveDocumentAs()
    {
        //Переключать представление на html вкладку.
        view.selectHtmlTab();
        //Создавать новый объект для выбора файла JFileChooser.
        JFileChooser fileChooser = new JFileChooser();
        //Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        fileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно "Save File" для выбора файла.
        int returnValue = fileChooser.showSaveDialog(view);
        //Если пользователь подтвердит выбор файла:
        if (returnValue == fileChooser.APPROVE_OPTION)
        {
            //Сохранять выбранный файл в поле currentFile.
            currentFile = fileChooser.getSelectedFile();
            //Устанавливать имя файла в качестве заголовка окна представления.
            view.setTitle(currentFile.getName());
            //Создавать FileWriter на базе currentFile.
            try (FileWriter fileWriter = new FileWriter(currentFile))
            {
                //Переписывать данные из документа document в объекта FileWriter-а
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e)
            {
                new ExceptionHandler().log(e);
            }
        }
    }
}
