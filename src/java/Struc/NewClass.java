/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Struc;

/**
 *
 * @author jonathan
 */
public class NewClass {
    
    
    <div id="inner_west" position="west" size="50%" style="  margin:0px; ">
                            <h:form id="formNode">     
                                <p:growl id="grow2" sticky="true" showDetail="true" />                         
                                 <p:panel header="Node"    style=" margin:0px; border:0px; padding: 0px;   " closeTitle="true" >

                                            <p:panelGrid columns="2"  style="border-width: 0px;  padding: 0px; width: 100%;  " >
                                                <h:outputText value="Name :" />  
                                                <h:inputText  value="#{ControlInfo.name}" id="Nom" size="20" style=" padding:0px; min-width: 98%; margin-left: 1%; margin-right: 1%; " /> 

                                                <h:outputText value="Description:" />  
                                                <p:inputTextarea rows="5" cols="30"  maxlength="100"  id="DescSIMPLE"     
                                                                 value="#{ControlInfo.desc}" autoResize="true" style=" background: #ffffff; padding:0px;min-width: 98%; margin-left: 1%; margin-right: 1%    " />  

                                                <h:outputText value="Father:" />  
                                                <h:inputText value="parent" id="pere" style=" padding:0px; min-width: 98%; margin-left: 1%; margin-right: 1%  "/>  

                                                <h:outputText value="Advanced Description :" />  
                                                <p:inputTextarea rows="5" cols="30"  maxlength="1000"  id="DescADVANCED"     
                                                                 value="#{ControlInfo.descadvance}" autoResize="true" style=" padding:0px; background: #ffffff; min-width: 98%; margin-left: 1%; margin-right: 1%   " />
                                                
                                                <h:outputText value="Type of integration: " /> 
                                                                     
                                                <p:selectOneRadio id="options"   > 
                                                   
                                                    <f:selectItem itemLabel="Continu" itemValue="continu"  />  
                                                    <f:selectItem itemLabel="Discret" itemValue="discret"  />  
                                                    <f:selectItem itemLabel="Algebraic" itemValue="algebraic"  />  
                                                    <!-- comtrol de l'action sur la liste déroulante -->
                                                    <f:ajax listener="#{ControlInfo.choixIntegration}" event="click" execute="options" render="inttt" />
   
                                                </p:selectOneRadio>

                                                <h:outputText value="Integration: " id="int"/>  
                                                <p:selectOneMenu value="#{ControlInfo.integrator}" var="type2" effect="fade" id="inttt" >  
                                                    <f:selectItems value="#{ControlInfo.integrator}" /> 
                                                </p:selectOneMenu>  

                                            </p:panelGrid>
                                        </p:panel>
                                      </h:form> 
                        </div>
}



<br />
                                        <h:outputText value="State Variable:" style=" padding:0px; min-width: 98%; margin-left: 1%; margin-right: 1%; "/>  
                                        <!--   Gestion du bouton pour add element -->
                                    <p:commandButton id="showDialogButton" type="button" value="Add Variable" onclick="dlg.show();" /> 
                                    <!-- pop-up demenandans le nom et la valeur -->
                                    <p:dialog header="Enter Information" widgetVar="dlg" resizable="false"> 
                                        
                                            <h:panelGrid columns="2" style="margin-bottom:10px">  
                                                <h:outputLabel for="Names" value="Names:" />  
                                                <p:inputText id="Names" value="#{ControlInfo.namesV}"  /> 
                                                <h:outputLabel for="Values" value="Values:" />
                                                <p:inputText id="Values" value="#{ControlInfo.valV}"  />
                                            </h:panelGrid>  

                                            <p:commandButton id="submitButton" value="Submit" update="listVar" oncomplete="dlg.hide();" actionListener="#{ControlInfo.addVariables(ControlInfo.namesV, ControlInfo.valV)}"/>  
                                        
                                    </p:dialog> 
                                        <!--  Generation de la liste -->
                                    <p:dataList id="listVar" value="#{ControlInfo.variables}" var="val" itemType="disc">  
                                       #{val.names} : 
                                        <h:inputText value="#{val.values}" id="Variableetat"/> 

                                          <!--  gestion de la suppresion de la variable -->
                                          <p:commandButton   update="listVar"  actionListener="#{ControlInfo.delVariables(val)}" icon="ui-icon-close" > 
                                                <p:confirm header="Confirmation" message="Are you sure delete?" icon="ui-icon-alert"  />                                             
                                        </p:commandButton >  
                                                
                                            <p:confirmDialog global="true" showEffect="fade" hideEffect="explode">  
                                                <p:commandButton value="Yes" type="button" styleClass="ui-confirmdialog-yes" icon="ui-icon-check" />  
                                                <p:commandButton value="No" type="button" styleClass="ui-confirmdialog-no" icon="ui-icon-close" />                                               
                                            </p:confirmDialog>     
                                    </p:dataList>   
                                        <br />
                                        <h:outputText value="Equation:" style=" padding:0px; min-width: 98%; margin-left: 1%; margin-right: 1%; "/>
                                        <p:commandButton value="Test"   id="testequation" action="null"  ajax="false" style="padding:0px; min-width: 98%; margin-left: 1%; margin-right: 1%; "/>
                                        <h:inputText value="ttt" id="equation" style="padding:0px; min-width: 98%; margin-left: 1%; margin-right: 1%; "/>  
                                        <br></br>
                                        <h:outputText value="Derivees :" style=" padding:0px; min-width: 98%; margin-left: 1%; margin-right: 1%; "/>  
                                    <p:dataList id="listVar2" value="#{ControlInfo.variables}" var="val2" itemType="disc"  >  
                                        <p:commandButton value="test"   id="testderivee" action="null"  ajax="false"/>
                                        <h:inputText value="#{val2.derive}" id="deriver"/>  
                                    </p:dataList>
                                        <br></br>
                                        <p:commandButton value="Input"   id="input" action="null"  ajax="false" style=" padding:0px; min-width: 98%; margin-left: 1%; margin-right: 1%; "/>
                                        <br></br>
                                        <p:commandButton value="Output"   id="output" action="null"  ajax="false" style=" padding:0px; min-width: 98%; margin-left: 1%; margin-right: 1%; "/>





<p:commandButton   update="listPara" actionListener="#{ControlInfo.delParameter(para)}" icon="ui-icon-close" > 
                                                <p:confirm header="Confirmation" message="Are you sure delete?" icon="ui-icon-alert" />  
                                            </p:commandButton>  
                                            <p:confirmDialog global="true" showEffect="fade" hideEffect="explode">  
                                                <p:commandButton value="Yes" type="button" styleClass="ui-confirmdialog-yes" icon="ui-icon-check"  />  
                                                <p:commandButton value="No" type="button" styleClass="ui-confirmdialog-no" icon="ui-icon-close" />       
                                            </p:confirmDialog>  