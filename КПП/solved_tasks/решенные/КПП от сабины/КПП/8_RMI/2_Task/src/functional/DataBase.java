package functional;

import functional.interfaces.DataBaseChangeListener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class DataBase {
    private ArrayList<Participant> database;
    private ArrayList<DataBaseChangeListener> listeners;
    private DataBaseChangeEvent event;

    public DataBase(){
        database=new ArrayList<Participant>();
        listeners=new ArrayList<DataBaseChangeListener>();
        event=new DataBaseChangeEvent(this);
    }

    public DataBase(ArrayList<Participant> database) {
        this.database = database;
    }

    public  int size() {
        return database.size();
    }

    public boolean isEmpty() {
        return database.isEmpty();
    }

    public Object get(int index) {
        return database.get(index);
    }

    public void set(int index, Participant participant) {
        database.set(index, participant);
        fireDataBaseChange();
    }

    public void add(Participant participant) {
        database.add(participant);
        fireDataBaseChange();
    }

    public void remove(int index) {
        database.remove(index);
        fireDataBaseChange();
    }

    public Collection getDatabase() {
        return database;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<database.size();i++)
            str.append((i+1)+") "+database.get(i).toString()+"\r\n");
        return str.toString();
    }

    public void clear(){
        database.clear();
        fireDataBaseChange();
    }

    public void addDataSheetChangeListener(DataBaseChangeListener listener){
        listeners.add(listener);
    }

    public void removeDataSheetChangeListener(DataBaseChangeListener listener){
        listeners.remove(listener);
    }

    public void fireDataBaseChange(){
        Iterator<DataBaseChangeListener> i=listeners.iterator();
        while (i.hasNext()) {
            (i.next()).dataChanged(event);
        }
    }

    public Document convertToDocument() throws ParserConfigurationException {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder=dbf.newDocumentBuilder();
        Document doc=docBuilder.newDocument();
        Element root=doc.createElement("DataBase");

        for (Participant o:database)
            root.appendChild(createElement("Participant",o,doc));
        doc.appendChild(root);
        return doc;
    }
    private Node createElement(String name, Object obj, Document document){
        Class cls=obj.getClass();
        Element res=document.createElement(name);
        if (cls.getSimpleName().equals("String")||cls.isPrimitive()) {
            res.setTextContent(obj.toString());
            return res;
        }
        Field[] fields=cls.getDeclaredFields();
        for(Field f:fields) {
            try {
                f.setAccessible(true);
                res.appendChild(createElement(f.getName(),f.get(obj),document));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
