# LegitSecurity Automation

LegitSecurity Automation is an automated testing project focused on testing a shopping store application. This document provides an overview of our automated build processes, which ensure that our testing suite remains reliable and efficient through continuous integration and testing.

## Build Automation

Our project employs a comprehensive CI/CD pipeline using GitHub Actions to automate builds and tests. This ensures that each contribution to the project is verified, maintaining the high quality and reliability of our testing suite.

### Scheduled Builds

- Daily Runs: Our tests are configured to run automatically every day at **10:00 AM UTC. This helps us detect and address any issues that might arise from changes in dependencies or external services early, ensuring the stability of our testing suite.

### Trigger on Push

- Master Branch: In addition to scheduled daily runs, our workflow is triggered on every push to the master branch. This ensures that new changes are immediately tested, keeping our main branch stable and deploy-ready at all times.

## Technology Stack

Our project leverages the following key technologies:

- Java 11: LegitSecurity Automation is written in Java 11 for its modern features, improved performance, and enhanced security.
- Selenium: For end-to-end testing, Selenium provides us with the capability to automate browser actions, ensuring that our application behaves as expected on various web browsers.
- TestNG: TestNG is used for test automation in LegitSecurity Automation, providing us with powerful testing capabilities and easy-to-use annotations.
- Allure Report: We have integrated an interface shell for Allure report, allowing us to generate comprehensive and visually appealing test reports.

## Testing Strategy

Our testing strategy includes:

- End-to-End Testing: LegitSecurity Automation performs end-to-end testing to ensure that the shopping store application behaves correctly in a production-like environment. These tests cover UI functionality, security aspects, and latency processes, providing comprehensive validation of the application.

## Infrastructure Overview

An explanation of the infrastructure's structure will be provided orally in detail, covering the architecture, deployment processes, and any other relevant aspects.