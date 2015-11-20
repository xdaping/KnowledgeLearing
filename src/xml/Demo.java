package xml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import net.sf.json.xml.XMLSerializer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;




public class Demo {
	
	public static void main(String[] args) {
		createXMlFile("data/testXML.xml");	
		parserXml("data/testXML.xml");
	}		
	
	static void parserXml(String fileName) {   
//		SAXBuilder builder=new SAXBuilder(false); 
		SAXBuilder builder=new SAXBuilder();
		try {   
			Document document=builder.build(fileName);   
			Element employees=document.getRootElement();    
			List<Element> employeeList=employees.getChildren("BaseInfo");   
			for(int i=0;i<employeeList.size(); i++){			
				Element employee=(Element)employeeList.get(i);   
				List<Element> employeeInfo=employee.getChildren();   
				for(int j=0;j<employeeInfo.size(); j++){		
					System.out.println(((Element)employeeInfo.get(j)).getName()+":"+((Element)employeeInfo.get(j)).getValue());   
				}   
			}
		} catch (JDOMException e) {   
			e.printStackTrace();   
		} catch (IOException e) {   
			e.printStackTrace();   
		}    
	}   
	
	static void createXMlFile(String fileName) {
		File file=new File(fileName);					
			//创建根节点
			Element root=new Element("ObjFlow");
			root.setAttribute("category","reserved");
			//根节点添加到文档中
			Document document=new Document(root);			

				Element baseinfo=new Element("BaseInfo");
					Element formOid=new Element("formOid");		
						formOid.setText("工单编号");
						baseinfo.addContent(formOid);
			
						Element taskName=new Element("taskName");
						taskName.setText("任务名称");
						baseinfo.addContent(taskName);						
					Element AdjustReason=new Element("AdjustReason");
					AdjustReason.setAttribute("category","good");
		
					Element items=new Element("items");
						Element item=new Element("item");
						
							Element villagename=new Element("villagename");			
							villagename.setText("小区名");
							item.addContent(villagename);			
				
							Element devicetype=new Element("devicetype");
							devicetype.setText("设备类型");
							item.addContent(devicetype);
				
							Element problemtime=new Element("problemtime");
							problemtime.setText("问题时间");
							item.addContent(problemtime);
							item.removeContent(problemtime);  //删除一个节点
							
							Element parametername=new Element("parametername");
							parametername.setText("指标或参数名");
							item.addContent(parametername);
							
				
							Element parametervalues=new Element("parametervalues");
							parametervalues.setText("指标或参数值");
							item.addContent(parametervalues);
						
						items.addContent(item);
					AdjustReason.addContent(items);
				baseinfo.addContent(AdjustReason);			

			root.addContent(baseinfo);
					
			XMLOutputter xmlout=new XMLOutputter(Format.getPrettyFormat());			
			
			OutputStream out;
			try {
				
				System.out.println(xmlout.outputString(document));
				System.out.println(xml2JSON(xmlout.outputString(document)));
				
				out = new FileOutputStream(file);
				xmlout.output(document, out);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}						
	}
	
	
	public static String xml2JSON(String xml){  
        return new XMLSerializer().read(xml).toString();  
    }  

}
