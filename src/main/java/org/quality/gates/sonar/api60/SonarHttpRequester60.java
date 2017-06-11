package org.quality.gates.sonar.api60;

import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClientBuilder;
import org.quality.gates.jenkins.plugin.GlobalConfigDataForSonarInstance;
import org.quality.gates.jenkins.plugin.JobConfigData;
import org.quality.gates.sonar.api.SonarHttpRequester;

/**
 * @author arkanjoms
 * @since 1.0.1
 */
public class SonarHttpRequester60 extends SonarHttpRequester {

    private static final String SONAR_API_LOGIN = "/api/authentication/login";

    private static final String SONAR_API_QUALITY_GATES_STATUS = "/api/qualitygates/project_status?projectKey=%s";

    private static final String SONAR_API_TASK_INFO = "/api/ce/component?componentId=%s";

    public SonarHttpRequester60() {
    }

    @Override
    protected String getSonarApiLogin() {
        return SONAR_API_LOGIN;
    }

    @Override
    protected String getSonarApiTaskInfoUrl() {
        return SONAR_API_TASK_INFO;
    }

    @Override
    protected String getSonarApiQualityGatesStatusUrl() {
        return SONAR_API_QUALITY_GATES_STATUS;
    }

    @Override
    protected String getSonarApiTaskInfoParameter(JobConfigData jobConfigData, GlobalConfigDataForSonarInstance globalConfigDataForSonarInstance) {
        return getComponentId(jobConfigData, globalConfigDataForSonarInstance);
    }
}
