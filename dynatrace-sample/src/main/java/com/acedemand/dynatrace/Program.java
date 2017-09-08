package com.acedemand.dynatrace;

import com.dynatrace.diagnostics.automation.rest.sdk.RESTEndpoint;
import com.dynatrace.diagnostics.automation.rest.sdk.entity.*;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.ArrayList;

/**
 * Created by Pamir on 5/28/2016.
 */
public class Program {
    public static void main(String[] args) {
        RESTEndpoint restEndpoint = new RESTEndpoint("admin", "admin", "https://192.168.64.133:8021");
        ArrayList<BaseConfiguration> baseConfigurationList = restEndpoint.getProfiles();
        BaseConfiguration monitoringConfiguration;
        for (BaseConfiguration baseConfiguration : baseConfigurationList) {
            System.out.println("baseConfiguration.getId() = " + baseConfiguration.getId());
            if (baseConfiguration.getId().equalsIgnoreCase("Monitoring"))
                monitoringConfiguration = baseConfiguration;
        }


        ArrayList<Agent> agetntList = restEndpoint.getAgents();
        for (Agent agent : agetntList) {
            System.out.println("agent.getName() = " + agent.getName());
            System.out.println("agent.getSystemProfile() = " + agent.getSystemProfile());


            ArrayList<? extends Record> recordList = restEndpoint.getObjects("RestPurePathDashboard", "Monitoring");

            for (Record record : recordList) {
                PurePath purePath = (PurePath) record;
                System.out.println(String.format("%s %s %s ", purePath.getName(), purePath.getExec(), purePath));


            }

            ArrayList<? extends Record> businessTranRecordList = restEndpoint.getObjects("BusinessTransactions", "Monitoring");
            for (Record record : businessTranRecordList) {
                BusinessTransaction businessTransaction = (BusinessTransaction) record;
                System.out.println(String.format("%s %s ", businessTransaction.getName(), businessTransaction.getGroup()));
                BusinessTransaction b;
            }
            ArrayList<? extends Record> methodRecordList = restEndpoint.getObjects("MethodDashboard", "Monitoring");
            for (Record record : methodRecordList) {
                Method method = (Method) record;
                System.out.println(String.format("%s %s %s", method.getApiName(), method.getName(), method.getExecStats().getAvg()));
            }


        }
        ArrayList<? extends Record> webRequestList = restEndpoint.getObjects("WebRequestDashboard", "Monitoring");
        for (Record record : webRequestList) {
            WebRequest webRequest = (WebRequest) record;
            System.out.println(String.format("%s %s %s", webRequest.getUri(), webRequest.getCount(), webRequest.getReceivedData().getAvg()));
        }
        ArrayList<? extends Record> databaseList = restEndpoint.getObjects("DatabaseDashboard", "Monitoring");
        for (Record record : databaseList) {
            DatabaseStatement databaseStatement = (DatabaseStatement) record;
            System.out.println(String.format("%s %s %s", databaseStatement.getSql(),databaseStatement.getCount(),databaseStatement.getExecStats().getAvg()));
        }

    }


}

