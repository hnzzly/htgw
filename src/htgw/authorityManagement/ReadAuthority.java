package htgw.authorityManagement;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class ReadAuthority extends HttpServlet {
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SAXReader reader=new SAXReader();
		Map<String,String> authorityList=new HashMap<String,String>();
		try {
			String path=config.getServletContext().getRealPath("/");
			Document document=reader.read(new File(path+"/web-inf/authorityConfig.xml"));
			Element root=document.getRootElement();
			for(Iterator<Element> a=root.elementIterator("authority") ;a.hasNext();){
				Element element=a.next();
				String authority=element.attributeValue("name");
				for(Iterator<Element> b=element.elementIterator("action");b.hasNext();){
					Element childElement=b.next();
					String action=childElement.getText();
					if(!authorityList.containsKey(action)){
						authorityList.put(action, authority);
					}else{
						String authorities=authorityList.get(action);
						int index=authorities.indexOf(authority);
						if(index<0){
							authorityList.put(action, authorities+" "+authority);
						}
					}
		
				}
	
			}
			config.getServletContext().setAttribute("authorityList", authorityList);
			System.out.print(authorityList);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
