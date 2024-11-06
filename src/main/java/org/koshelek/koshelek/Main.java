package org.koshelek.koshelek;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class Main {
    public static void main(String[] args) {
            LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(DiscoverySelectors.selectClass(RegistrationPageTest.class)).build();
            Launcher launcher = LauncherFactory.create();
            SummaryGeneratingListener listener = new SummaryGeneratingListener();
            launcher.registerTestExecutionListeners(listener);
            launcher.execute(request);
            TestExecutionSummary summary = listener.getSummary();
            summary.printTo(new java.io.PrintWriter(System.out));
            if (summary.getFailures().size() > 0) {
                StringBuilder failureMessage = new StringBuilder("Test failures:\n");
                summary.getFailures().forEach(failure -> {
                    failureMessage.append(failure.getTestIdentifier().getDisplayName()).append(": ")
                            .append(failure.getException().getMessage())
                            .append("\n");
                });
                System.out.println(failureMessage.toString());
            } else {
                System.out.println("All tests passed");
            }
        }
    }


