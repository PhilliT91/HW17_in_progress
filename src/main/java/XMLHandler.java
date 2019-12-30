import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class XMLHandler extends DefaultHandler {
Stack<String> stack = new Stack<String>();
int openTagCount=0;
int closeTagcount=0;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      /*if (qName.equals("user")) {
            String firstName = attributes.getValue("firstName");
            String lastName = attributes.getValue("lastName");
            String age = attributes.getValue("age");
            String email = attributes.getValue("email");
            String technology = attributes.getValue("technology");
            userList.add(new User(firstName, lastName, Integer.valueOf(age), email, technology, null));
        } else if (qName.equals("admin")) {

            String firstName = attributes.getValue("firstName");
            String lastName = attributes.getValue("lastName");
            String email = attributes.getValue("email");
            String permission = attributes.getValue("permission");
            adminList.add(new Admin(firstName, lastName, email, permission));
        }*/
        if(stack.empty()){
            stack.push(qName);
        }
       else if(!qName.equals(stack.peek())){
            stack.push(qName);
            System.out.println();
    }
        System.out.println("op "+ openTagCount);
        openTagCount++;
        ;

    }

    @Override
    public void startDocument() throws SAXException {
        // Тут будет логика реакции на начало документа
    }

    @Override
    public void endDocument() throws SAXException {
       if(stack.empty()) {
           System.out.println("file is valid"); }
       else{
           System.out.println("file is INVALID!!!");
       }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       if(stack.empty()){
           stack.push(qName);
       }
        else if(qName.equals(stack.peek())) {
           stack.pop();
       }
        else{
           stack.push(qName);
       }
        System.out.println("cl "+closeTagcount);
        closeTagcount++;

    }
}


