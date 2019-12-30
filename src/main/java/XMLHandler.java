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


