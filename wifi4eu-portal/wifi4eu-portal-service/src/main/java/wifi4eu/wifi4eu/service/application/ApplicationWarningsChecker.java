package wifi4eu.wifi4eu.service.application;

import wifi4eu.wifi4eu.entity.application.ApplicationIssueUtil;

public class ApplicationWarningsChecker {

    public static boolean registrationHasWarning1(ApplicationIssueUtil applicationIssueUtil) {
        boolean warning1 = false;
        String countryCode = applicationIssueUtil.getCountryCode();
        String userEmail = applicationIssueUtil.getUserEmail();
        String userEcasEmail = applicationIssueUtil.getUserEcasEmail();
        String mayorEmail = applicationIssueUtil.getMayorEmail();
        if(countryCode != null && userEcasEmail != null && userEmail != null) {
            switch (countryCode.toUpperCase()) {
                case "AT":
                    if (!userEmail.trim().toLowerCase().endsWith(".at") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".at") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".at")) {
                        warning1 = true;
                    }
                    break;
                case "BE":
                    if (!userEmail.trim().toLowerCase().endsWith(".be") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".be") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".be")) {
                        warning1 = true;
                    }
                    break;
                case "BG":
                    if (!userEmail.trim().toLowerCase().endsWith(".bg") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".bg") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".bg")) {
                        warning1 = true;
                    }
                    break;
                case "HR":
                    if (!userEmail.trim().toLowerCase().endsWith(".hr") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".hr") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".hr")) {
                        warning1 = true;
                    }
                    break;
                case "CY":
                    if (!userEmail.trim().toLowerCase().endsWith(".cy") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".cy") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".cy")) {
                        warning1 = true;
                    }
                    break;
                case "CZ":
                    if (!userEmail.trim().toLowerCase().endsWith(".cz") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".cz") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".cz")) {
                        warning1 = true;
                    }
                    break;
                case "DK":
                    if (!userEmail.trim().toLowerCase().endsWith(".dk") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".dk") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".dk")) {
                        warning1 = true;
                    }
                    break;
                case "EE":
                    if (!userEmail.trim().toLowerCase().endsWith(".ee") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".ee") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".ee")) {
                        warning1 = true;
                    }
                    break;
                case "FI":
                    if (!userEmail.trim().toLowerCase().endsWith(".fi") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".fi") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".fi")) {
                        warning1 = true;
                    }
                    break;
                case "FR":
                    if (!userEmail.trim().toLowerCase().endsWith(".fr") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".fr") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".fr")) {
                        warning1 = true;
                    }
                    break;
                case "DE":
                    if (!userEmail.trim().toLowerCase().endsWith(".de") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".de") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".de")) {
                        warning1 = true;
                    }
                    break;
                case "EL":
                    if (!userEmail.trim().toLowerCase().endsWith(".el") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".el") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".el")) {
                        warning1 = true;
                    }
                    break;
                case "HU":
                    if (!userEmail.trim().toLowerCase().endsWith(".hu") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".hu") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".hu")) {
                        warning1 = true;
                    }
                    break;
                case "IS":
                    if (!userEmail.trim().toLowerCase().endsWith(".is") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".is") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".is")) {
                        warning1 = true;
                    }
                    break;
                case "IE":
                    if (!userEmail.trim().toLowerCase().endsWith(".ie") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".ie") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".ie")) {
                        warning1 = true;
                    }
                    break;
                case "IT":
                    if (!userEmail.trim().toLowerCase().endsWith(".it") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".it") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".it")) {
                        warning1 = true;
                    }
                    break;
                case "LV":
                    if (!userEmail.trim().toLowerCase().endsWith(".lv") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".lv") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".lv")) {
                        warning1 = true;
                    }
                    break;
                case "LT":
                    if (!userEmail.trim().toLowerCase().endsWith(".lt") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".lt") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".lt")) {
                        warning1 = true;
                    }
                    break;
                case "LU":
                    if (!userEmail.trim().toLowerCase().endsWith(".lu") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".lu") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".lu")) {
                        warning1 = true;
                    }
                    break;
                case "MT":
                    if (!userEmail.trim().toLowerCase().endsWith(".mt") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".mt") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".mt")) {
                        warning1 = true;
                    }
                    break;
                case "NL":
                    if (!userEmail.trim().toLowerCase().endsWith(".nl") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".nl") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".nl")) {
                        warning1 = true;
                    }
                    break;
                case "NO":
                    if (!userEmail.trim().toLowerCase().endsWith(".no") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".no") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".no")) {
                        warning1 = true;
                    }
                    break;
                case "PL":
                    if (!userEmail.trim().toLowerCase().endsWith(".pl") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".pl") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".pl")) {
                        warning1 = true;
                    }
                    break;
                case "PT":
                    if (!userEmail.trim().toLowerCase().endsWith(".pt") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".pt") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".pt")) {
                        warning1 = true;
                    }
                    break;
                case "RO":
                    if (!userEmail.trim().toLowerCase().endsWith(".ro") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".ro") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".ro")) {
                        warning1 = true;
                    }
                    break;
                case "SK":
                    if (!userEmail.trim().toLowerCase().endsWith(".sk") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".sk") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".sk")) {
                        warning1 = true;
                    }
                    break;
                case "SI":
                    if (!userEmail.trim().toLowerCase().endsWith(".si") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".si") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".si")) {
                        warning1 = true;
                    }
                    break;
                case "ES":
                    if (!(
                            userEmail.trim().toLowerCase().endsWith(".es") ||
                                    userEmail.trim().toLowerCase().endsWith(".cat") ||
                                    userEmail.trim().toLowerCase().endsWith(".gal") ||
                                    userEmail.trim().toLowerCase().endsWith(".eus")
                    ) || !(
                            userEcasEmail.trim().toLowerCase().endsWith(".es") ||
                                    userEcasEmail.trim().toLowerCase().endsWith(".cat") ||
                                    userEcasEmail.trim().toLowerCase().endsWith(".gal") ||
                                    userEcasEmail.trim().toLowerCase().endsWith(".eus")
                    ) || !(
                            mayorEmail.trim().toLowerCase().endsWith(".es") ||
                                    mayorEmail.trim().toLowerCase().endsWith(".cat") ||
                                    mayorEmail.trim().toLowerCase().endsWith(".gal") ||
                                    mayorEmail.trim().toLowerCase().endsWith(".eus")
                    )) {
                        warning1 = true;
                    }
                    break;
                case "SE":
                    if (!userEmail.trim().toLowerCase().endsWith(".se") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".se") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".se")) {
                        warning1 = true;
                    }
                    break;
                case "UK":
                    if (!userEmail.trim().toLowerCase().endsWith(".uk") ||
                            !userEcasEmail.trim().toLowerCase().endsWith(".uk") ||
                            !mayorEmail.trim().toLowerCase().endsWith(".uk")) {
                        warning1 = true;
                    }
                    break;
            }
        }
        return warning1;
    }

    public static boolean registrationHasWarning3(ApplicationIssueUtil applicationIssueUtil) {
        boolean warning3 = false;
        String countryCode = applicationIssueUtil.getCountryCode();
        String userLang = applicationIssueUtil.getUserLang();
        if(countryCode != null && userLang != null) {
            switch (countryCode.toUpperCase()) {
                case "AT":
                    if (!(userLang.toLowerCase().equals("de"))) {
                        warning3 = true;
                    }
                    break;
                case "BE":
                    if (!(userLang.toLowerCase().equals("de") ||
                            userLang.toLowerCase().equals("nl") ||
                            userLang.toLowerCase().equals("fr"))) {
                        warning3 = true;
                    }
                    break;
                case "BG":
                    if (!(userLang.toLowerCase().equals("bg"))) {
                        warning3 = true;
                    }
                    break;
                case "HR":
                    if (!(userLang.toLowerCase().equals("hr"))) {
                        warning3 = true;
                    }
                    break;
                case "CY":
                    if (!(userLang.toLowerCase().equals("el"))) {
                        warning3 = true;
                    }
                    break;
                case "CZ":
                    if (!(userLang.toLowerCase().equals("cs"))) {
                        warning3 = true;
                    }
                    break;
                case "DK":
                    if (!(userLang.toLowerCase().equals("da"))) {
                        warning3 = true;
                    }
                    break;
                case "EE":
                    if (!(userLang.toLowerCase().equals("et"))) {
                        warning3 = true;
                    }
                    break;
                case "FI":
                    if (!(userLang.toLowerCase().equals("fi") ||
                            userLang.toLowerCase().equals("sv"))) {
                        warning3 = true;
                    }
                    break;
                case "FR":
                    if (!(userLang.toLowerCase().equals("fr"))) {
                        warning3 = true;
                    }
                    break;
                case "DE":
                    if (!(userLang.toLowerCase().equals("de"))) {
                        warning3 = true;
                    }
                    break;
                case "EL":
                    if (!(userLang.toLowerCase().equals("el"))) {
                        warning3 = true;
                    }
                    break;
                case "HU":
                    if (!(userLang.toLowerCase().equals("hu"))) {
                        warning3 = true;
                    }
                    break;
                case "IS":
                    if (!(userLang.toLowerCase().equals("en"))) {
                        warning3 = true;
                    }
                    break;
                case "IE":
                    if (!(userLang.toLowerCase().equals("en") ||
                            userLang.toLowerCase().equals("ga"))) {
                        warning3 = true;
                    }
                    break;
                case "IT":
                    if (!(userLang.toLowerCase().equals("it"))) {
                        warning3 = true;
                    }
                    break;
                case "LV":
                    if (!(userLang.toLowerCase().equals("lv"))) {
                        warning3 = true;
                    }
                    break;
                case "LT":
                    if (!(userLang.toLowerCase().equals("lt"))) {
                        warning3 = true;
                    }
                    break;
                case "LU":
                    if (!(userLang.toLowerCase().equals("fr") ||
                            userLang.toLowerCase().equals("de"))) {
                        warning3 = true;
                    }
                    break;
                case "MT":
                    if (!(userLang.toLowerCase().equals("mt") ||
                            userLang.toLowerCase().equals("en"))) {
                        warning3 = true;
                    }
                    break;
                case "NL":
                    if (!(userLang.toLowerCase().equals("nl"))) {
                        warning3 = true;
                    }
                    break;
                case "NO":
                    if (!(userLang.toLowerCase().equals("en"))) {
                        warning3 = true;
                    }
                    break;
                case "PL":
                    if (!(userLang.toLowerCase().equals("pl"))) {
                        warning3 = true;
                    }
                    break;
                case "PT":
                    if (!(userLang.toLowerCase().equals("pt"))) {
                        warning3 = true;
                    }
                    break;
                case "RO":
                    if (!(userLang.toLowerCase().equals("ro"))) {
                        warning3 = true;
                    }
                    break;
                case "SK":
                    if (!(userLang.toLowerCase().equals("sk"))) {
                        warning3 = true;
                    }
                    break;
                case "SI":
                    if (!(userLang.toLowerCase().equals("sl"))) {
                        warning3 = true;
                    }
                    break;
                case "ES":
                    if (!(userLang.toLowerCase().equals("es"))) {
                        warning3 = true;
                    }
                    break;
                case "SE":
                    if (!(userLang.toLowerCase().equals("sv"))) {
                        warning3 = true;
                    }
                    break;
                case "UK":
                    if (!(userLang.toLowerCase().equals("en"))) {
                        warning3 = true;
                    }
                    break;
            }
        }
        return warning3;
    }
}
