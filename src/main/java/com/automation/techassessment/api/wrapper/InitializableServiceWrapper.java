package com.automation.techassessment.api.wrapper;

import com.automation.techassessment.api.ApiClient;

/**
 * All High level APIs should implement this in order to get the root SoFiApiClient of the current session.
 * This gives you access to not only other high level apis but also the low-level apis that are tied to the current
 * login.
 */
public interface InitializableServiceWrapper {
    /**
     * Initialize is called right after the class is created by SoFiApiClient#getServiceWrapper.  It should NOT make
     * api calls, this should only store the SoFiApiClient root.
     *
     * @param root The base object of the High Level API client tree.
     */
    void initialize(ApiClient root);
}
