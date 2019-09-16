/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Lenovo
 */
public class AllMethod {
    public static String generateToken(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
       StringBuilder sb = new StringBuilder(20);
       for (int i = 0; i < 20; i++) { 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        }
       
       return sb.toString();
    }
    public static void sendEmail(String email, String name, String token) {
        final String username = "mii.bootcamp29@gmail.com";
        final String password = "bootcampbatch29";
        String pesan = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> \n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\" style=\"background-color: rgb(240, 240, 240);\"> \n"
                + " <head> \n"
                + "  <title></title> \n"
                + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /> \n"
                + "  <meta charset=\"utf-8\" /> \n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" /> \n"
                + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /> \n"
                + "  <style type=\"text/css\"> /* GT AMERICA */ @font-face { font-display: fallback; font-family: 'GT America Regular'; font-weight: 400; src: url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Regular.woff2') format('woff2'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Regular.woff') format('woff'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Regular.ttf') format('truetype'); } @font-face { font-display: fallback; font-family: 'GT America Medium'; font-weight: 600; src: url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Medium.woff2') format('woff2'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Medium.woff') format('woff'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Medium.ttf') format('truetype'); } @font-face { font-display: fallback; font-family: 'GT America Condensed Bold'; font-weight: 700; src: url('https://www.exploretock.com/fonts/gt-america/GT-America-Condensed-Bold.woff2') format('woff2'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Condensed-Bold.woff') format('woff'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Condensed-Bold.ttf') format('truetype'); } /* CLIENT-SPECIFIC RESET */ body, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; } /* Prevent WebKit and Windows mobile changing default text sizes */ table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; } /* Remove spacing between tables in Outlook 2007 and up */ img { -ms-interpolation-mode: bicubic; } /* Allow smoother rendering of resized image in Internet Explorer */ .im { color: inherit !important; } /* DEVICE-SPECIFIC RESET */ a[x-apple-data-detectors] { color: inherit !important; text-decoration: none !important; font-size: inherit !important; font-family: inherit !important; font-weight: inherit !important; line-height: inherit !important; } /* iOS BLUE LINKS */ /* RESET */ img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; display: block; } table { border-collapse: collapse; } table td { border-collapse: collapse; display: table-cell; } body { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; } /* BG COLORS */ .mainTable { background-color: #F0F0F0; } .mainTable--hospitality { background-color: #f7f2ed; } html { background-color: #F0F0F0; } /* VARIABLES */ .bg-white { background-color: white; } .hr { /* Cross-client horizontal rule. Adapted from https://litmus.com/community/discussions/4633-is-there-a-reliable-1px-horizontal-rule-method */ background-color: #d3d3d8; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; mso-line-height-rule: exactly; line-height: 1px; } .textAlignLeft { text-align: left !important; } .textAlignRight { text-align: right !important; } .textAlignCenter{ text-align: center !important; } .mt1 { margin-top: 6px; } .list { padding-left: 18px; margin: 0; } /* TYPOGRAPHY */ body { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 400; color: #4f4f65; -webkit-font-smoothing: antialiased; -ms-text-size-adjust:100%; -moz-osx-font-smoothing: grayscale; font-smoothing: always; text-rendering: optimizeLegibility; } .h1 { font-family: 'GT America Condensed Bold', 'Roboto Condensed', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 700; vertical-align: middle; font-size: 36px; line-height: 42px; } .h2 { font-family: 'GT America Medium', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 600; vertical-align: middle; font-size: 16px; line-height: 24px; } .text { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 400; font-size: 16px; line-height: 21px; } .text-list { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 400; font-size: 16px; line-height: 25px; } .textSmall { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 400; font-size: 14px; } .text-xsmall { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-size: 11px; text-transform: uppercase; line-height: 22px; letter-spacing: 1px; } .text-bold { font-weight: 600; } .text-link { text-decoration: underline; } .text-linkNoUnderline { text-decoration: none; } .text-strike { text-decoration: line-through; } /* FONT COLORS */ .textColorDark { color: #23233e; } .textColorNormal { color: #4f4f65; } .textColorBlue { color: #2020c0; } .textColorGrayDark { color: #7B7B8B; } .textColorGray { color: #A5A8AD; } .textColorWhite { color: #FFFFFF; } .textColorRed { color: #df3232; } /* BUTTON */ .Button-primary-wrapper { border-radius: 3px; background-color: #2020C0; } .Button-primary { font-family: 'GT America Medium', 'Roboto', 'Helvetica', 'Arial', sans-serif; border-radius: 3px; border: 1px solid #2020C0; color: #ffffff; display: block; font-size: 16px; font-weight: 600; padding: 18px; text-decoration: none; } .Button-secondary-wrapper { border-radius: 3px; background-color: #ffffff; } .Button-secondary { font-family: 'GT America Medium', 'Roboto', 'Helvetica', 'Arial', sans-serif; border-radius: 3px; border: 1px solid #2020C0; color: #2020C0; display: block; font-size: 16px; font-weight: 600; padding: 18px; text-decoration: none; } /* LAYOUT */ .Content-container { padding-left: 60px; padding-right: 60px; } .Content-container--main { padding-top: 54px; padding-bottom: 60px; } .Content { width: 580px; margin: 0 auto; } .wrapper { max-width: 600px; } .section { padding: 24px 0px; border-bottom: 1px solid #d3d3d8; } .section--noBorder { padding: 24px 0px 0; } .section--last { padding: 24px 0px; } .message { background-color: #F4F4F5; padding: 18px; } .card { border: 1px solid #d3d3d8; padding: 18px; } /* HEADER */ .header-tockLogoImage { display: block; color: #F0F0F0; } .header-heroImage { padding-bottom: 24px; } /* PREHEADER */ .preheader { display: none; font-size: 1px; color: #FFFFFF; line-height: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; } /* BANNER */ .notice { padding: 12px; background: #23233E; color: #FFFFFF; display: block; font-size: 14px; font-family: 'GT America Medium', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 600; } /* INTRO */ .section--intro { padding-bottom: 48px; } /* BOOKING INFO */ .business-logo__container { width: 48px; height: 48px; border-radius: 3px; border: 1px solid #d3d3d8; overflow: hidden; } .business-logo__image { border: 1px solid transparent; border-radius: 3px; width: 48px; height: 48px; display: block; } .business-address--address { width: 50%; } .business-address--map { width: 50%; } .business-address--map-image { width: 100%; } /* MOBILE TICKETS */ .mobile-ticket--description { width: 65%; margin-top: 12px; margin-right: 5%; } .mobile-ticket--code { width: 30%; } .mobile-ticket--code-image { width: 100%; } /* RESERVATION ACTIONS */ .linksTable { border-bottom: 1px solid #d3d3d8; } .linksTableRow { padding: 24px 12px; } .actions-icon { vertical-align: middle; } .actions-text { vertical-align: middle; } /* RECEIPT */ .receipt__container { border: 1px solid #d3d3d8; padding: 24px; } .receipt__row { border-top: 1px solid #d3d3d8; } /* FEEDBACK ICONS */ .feedback-link { border: 1px solid #d4d5da; border-radius: 3px; display: inline-block; width: calc(32% - 2px); padding: 10px 0; } .feedback-link-bumper { display: inline-block; width: 1%; } .feedback-link img { height: 50px; width: 50px; } /* SOCIAL ICONS */ .social-link { display: inline-block; width: auto; } .social-link-text { padding: 14px 24px 14px 14px; } /* TABLET STYLES */ @media screen and (max-width: 648px) { /* DEVICE-SPECIFIC RESET */ div[style*='margin: 16px 0;'] { margin: 0 !important; } /* ANDROID CENTER FIX */ /* LAYOUT */ .wrapper { width: 100% !important; max-width: 100% !important; } .Content { width: 90% !important; } .Content-container { padding-left: 36px !important; padding-right: 36px !important; } .Content-container--main { padding-top: 30px !important; padding-bottom: 42px !important; } .responsiveTable { width: 100% !important; } /* RESERVATION ACTIONS */ .linksTableRow { padding-left: 0 !important; padding-right: 0 !important; padding-top: 12px !important; padding-bottom: 12px !important; } .linksTableRow--borderRight { border-right: none !important; padding-left: 0 !important; padding-right: 0 !important; } /* FEEDBACK LINK */ .feedback-link img { height: 38px !important; width: 38px !important; } } /* MOBILE STYLES */ @media screen and (max-width: 480px) { /* TYPOGRAPHY */ .h1 { font-size: 30px !important; line-height: 30px !important; } .text { font-size: 16px !important; line-height: 22px !important; } /* BUTTON */ .mobile-buttonContainer { width: 100% !important; } /* LAYOUT */ .Content { width: 100% !important; } .Content-container { padding-left: 18px !important; padding-right: 18px !important; } .Content-container--main { padding-top: 24px !important; padding-bottom: 30px !important; } .section { padding: 18px 0 !important; } .section--last { padding: 18px 0 !important; } .header { padding: 0 18px !important; } .business-address--address { width: 100% !important; } .business-address--map { margin-top: 30px !important; width: 100% !important; } .mobile-ticket--description { width: 100% !important; margin-top: 0px !important; } .mobile-ticket--code { margin-top: 30px !important; margin-left: 0; width: 100% !important; } /* RECEIPT */ .receipt__container { padding: 12px !important; } /* SOCIAL ICONS */ .social-link { display: block !important; width: 100% !important; border-bottom: 1px solid #d3d3d8 !important; } /* INTRO */ .section--intro { padding-top: 18px !important; padding-bottom: 18px !important; } } </style> \n"
                + " </head> \n"
                + " <body style=\"margin: 0 !important; padding: 0 !important; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; height: 100%; margin: 0; padding: 0; width: 100%; font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-weight: 400; color: rgb(79, 79, 101); -webkit-font-smoothing: antialiased; -ms-text-size-adjust: 100%; -moz-osx-font-smoothing: grayscale; font-smoothing: always; text-rendering: optimizeLegibility;\"> \n"
                + "  <!-- EXTRA METADATA MARKUP --> \n"
                + "  <!--[if mso]>\n"
                + "    <style type=\"text/css\">\n"
                + ".h1 {font-family: 'Helvetica', 'Arial', sans-serif !important; font-weight: 700 !important; vertical-align: middle !important; font-size: 36px !important; mso-line-height-rule: exactly;line-height: 42px !important;}\n"
                + ".h2 {font-family: 'Helvetica', 'Arial', sans-serif !important;font-weight: 600 !important;vertical-align: middle !important;font-size: 16px !important;mso-line-height-rule: exactly;line-height: 24px !important;}\n"
                + ".text {font-family: 'Helvetica', 'Arial', sans-serif !important;font-weight: 400 !important;font-size: 16px !important;mso-line-height-rule: exactly;line-height: 21px !important;}\n"
                + ".text-list {font-family: 'Helvetica', 'Arial', sans-serif !important;font-weight: 400 !important;font-size: 16px !important;mso-line-height-rule: exactly;line-height: 25px !important;}\n"
                + ".textSmall {font-family: 'Helvetica', 'Arial', sans-serif !important;font-weight: 400 !important;font-size: 14px !important;}\n"
                + ".text-xsmall {font-family: 'Helvetica', 'Arial', sans-serif !important;font-size: 11px !important;text-transform: uppercase !important;mso-line-height-rule: exactly;line-height: 22px !important;letter-spacing: 1px !important;}\n"
                + ".text-bold {font-weight: 600 !important;}\n"
                + ".text-link {text-decoration: underline !important;}\n"
                + ".text-linkNoUnderline {text-decoration: none !important;}\n"
                + ".text-strike {text-decoration: line-through !important;}\n"
                + ".textColorDark {color: #23233e !important;}\n"
                + ".textColorNormal {color: #4f4f65 !important;}\n"
                + ".textColorBlue {color: #2020c0 !important;}\n"
                + ".textColorGray {color: #A5A8AD !important;}\n"
                + ".textColorWhite {color: #FFFFFF !important;}\n"
                + ".Button-primary {font-family: 'Helvetica', 'Arial', sans-serif !important;border-radius: 3px !important;border: 1px solid #2020C0 !important;color: #ffffff !important;display: block !important;font-size: 16px !important;font-weight: 600 !important;padding: 18px !important;text-decoration: none !important;}\n"
                + ".Button-secondary {font-family: 'Helvetica', 'Arial', sans-serif !important;border-radius: 3px !important;border: 1px solid #2020C0 !important;color: #2020C0 !important;display: block !important;font-size: 16px !important;font-weight: 600 !important;padding: 18px !important;text-decoration: none !important;}\n"
                + "    </style>\n"
                + "    <![endif]--> \n"
                + "  <!-- HIDDEN PREHEADER TEXT --> \n"
                + "  <div class=\"preheader\" style=\"display: none; font-size: 1px; color: rgb(255, 255, 255); line-height: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> \n"
                + "  </div> \n"
                + "  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\" mainTable  \" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; background-color: rgb(240, 240, 240);\"> \n"
                + "   <!-- HEADER --> \n"
                + "   <tr> \n"
                + "    <td align=\"center\" class=\"header\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\">\n"
                + "    <tr>\n"
                + "    <td align=\"center\" valign=\"top\" width=\"600\">\n"
                + "    <![endif]--> \n"
                + "     <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"Content\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 580px; margin: 0 auto;\"> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr> \n"
                + "       <td align=\"left\" valign=\"middle\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> </td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "     </table> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "    </td>\n"
                + "    </tr>\n"
                + "    </table>\n"
                + "    <![endif]--> </td> \n"
                + "   </tr> \n"
                + "   <!-- CONTENT --> \n"
                + "   <tr> \n"
                + "    <td align=\"center\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\">\n"
                + "    <tr>\n"
                + "    <td align=\"center\" valign=\"top\" width=\"600\">\n"
                + "    <![endif]--> \n"
                + "     <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"Content bg-white\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; background-color: white; width: 580px; margin: 0 auto;\"> \n"
                + "      <tr> \n"
                + "       <td class=\"Content-container Content-container--main text textColorNormal\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-weight: 400; font-size: 16px; line-height: 21px; color: rgb(79, 79, 101); padding-left: 60px; padding-right: 60px; padding-top: 54px; padding-bottom: 60px;\"> \n"
                + "        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse;\"> \n"
                + "         <tr> \n"
                + "          <td valign=\"top\" align=\"left\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "           <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse;\"> \n"
                + "            <tr> \n"
                + "             <td align=\"left\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> <span class=\"h1 textColorDark\" style=\"font-family: &quot;GT America Condensed Bold&quot;, &quot;Roboto Condensed&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-weight: 700; vertical-align: middle; font-size: 36px; line-height: 42px; color: rgb(35, 35, 62);\">Reset your password</span> </td> \n"
                + "            </tr> \n"
                + "            <tr class=\"spacer\"> \n"
                + "             <td height=\"18px\" colspan=\"2\" style=\"font-size: 18px; line-height:18px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "            </tr> \n"
                + "            <tr> \n"
                + "             <td align=\"left\" colspan=\"2\" valign=\"top\" width=\"100%\" height=\"1\" class=\"hr\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; background-color: rgb(211, 211, 216); border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; mso-line-height-rule: exactly; line-height: 1px;\">\n"
                + "              <!--[if gte mso 15]>&nbsp;<![endif]--></td> \n"
                + "            </tr> \n"
                + "            <tr class=\"spacer\"> \n"
                + "             <td height=\"18px\" colspan=\"2\" style=\"font-size: 18px; line-height:18px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "            </tr> \n"
                + "           </table> </td> \n"
                + "         </tr> \n"
                + "         <tr> \n"
                + "          <td valign=\"top\" align=\"left\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "           <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse;\"> \n"
                + "            <tr> \n"
                + "             <td align=\"left\" class=\"text textColorNormal\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-weight: 400; font-size: 16px; line-height: 21px; color: rgb(79, 79, 101);\"> Need to reset your password? No problem! Just click the button below and you’ll be on your way. If you did not make this request, please ignore this email. </td> \n"
                + "            </tr> \n"
                + "            <tr class=\"spacer\"> \n"
                + "             <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "            </tr> \n"
                + "            <tr class=\"spacer\"> \n"
                + "             <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "            </tr> \n"
                + "            <tr> \n"
                + "             <td align=\"center\" valign=\"center\" width=\"100%\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "              <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse;\"> \n"
                + "               <tr> \n"
                + "                <td align=\"center\" valign=\"center\" width=\"100%\" class=\"Button-primary-wrapper\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; border-radius: 3px; background-color: rgb(32, 32, 192);\"> <a href=\"http://localhost:8084/Penempatan/verifikasiservlet?v="+token+"\" target=\"_blank\" class=\"Button-primary\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; font-family: &quot;GT America Medium&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; border-radius: 3px; border: 1px solid rgb(32, 32, 192); color: rgb(255, 255, 255); display: block; font-size: 16px; font-weight: 600; padding: 18px; text-decoration: none;\"> Reset your password </a> </td> \n"
                + "               </tr> \n"
                + "              </table> </td> \n"
                + "            </tr> \n"
                + "           </table> </td> \n"
                + "         </tr> \n"
                + "        </table> </td> \n"
                + "      </tr> \n"
                + "     </table> </td> \n"
                + "   </tr> \n"
                + "   <!-- FOOTER --> \n"
                + "   <tr> \n"
                + "    <td align=\"center\" class=\"Content\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; width: 580px; margin: 0 auto;\"> \n"
                + "     <!-- Will most likely required a feature flag --> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\">\n"
                + "<tr>\n"
                + "<td align=\"center\" valign=\"top\" width=\"600\">\n"
                + "<![endif]--> \n"
                + "     <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"Content-container\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; padding-left: 60px; padding-right: 60px;\"> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr> \n"
                + "       <td align=\"center\" valign=\"top\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> <a href=\"https://www.metrodata.co.id/\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\"> <img src=\"https://images.glints.com/unsafe/1024x0/glints-dashboard.s3.amazonaws.com/company-logo/cf7b623f8414e3edc674eacbe49160c8.png\" width=\"30\" height=\"30\" alt=\"Tock\" border=\"0\" style=\"-ms-interpolation-mode: bicubic; border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; display: block;\" /> </a> </td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"18px\" colspan=\"2\" style=\"font-size: 18px; line-height:18px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr> \n"
                + "       <td align=\"center\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "        <div class=\"text-xsmall textColorNormal\" style=\"font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-size: 11px; text-transform: uppercase; line-height: 22px; letter-spacing: 1px; color: rgb(79, 79, 101);\">\n"
                + "         © 2019 PT Metrodata Electronics, Tbk.\n"
                + "        </div> \n"
                + "        <div class=\"text-xsmall textColorNormal\" style=\"font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-size: 11px; text-transform: uppercase; line-height: 22px; letter-spacing: 1px; color: rgb(79, 79, 101);\">\n"
                + "         All Rights Reserved\n"
                + "        </div> </td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "     </table> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "<![endif]--> </td> \n"
                + "   </tr> \n"
                + "  </table> \n"
                + " \n"
                + "</body> \n"
                + "</html>", subjek = "Reset Your Password, " + name + "!";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mii.bootcamp29@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subjek);
            message.setContent(pesan, "text/html");

            Transport.send(message);
            System.out.println("done");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public static void sendInterview(String email, String name, String id) {
        final String username = "mii.bootcamp29@gmail.com";
        final String password = "bootcampbatch29";
        String pesan = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> \n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\" style=\"background-color: rgb(240, 240, 240);\"> \n"
                + " <head> \n"
                + "  <title></title> \n"
                + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /> \n"
                + "  <meta charset=\"utf-8\" /> \n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" /> \n"
                + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /> \n"
                + "  <style type=\"text/css\"> /* GT AMERICA */ @font-face { font-display: fallback; font-family: 'GT America Regular'; font-weight: 400; src: url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Regular.woff2') format('woff2'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Regular.woff') format('woff'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Regular.ttf') format('truetype'); } @font-face { font-display: fallback; font-family: 'GT America Medium'; font-weight: 600; src: url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Medium.woff2') format('woff2'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Medium.woff') format('woff'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Standard-Medium.ttf') format('truetype'); } @font-face { font-display: fallback; font-family: 'GT America Condensed Bold'; font-weight: 700; src: url('https://www.exploretock.com/fonts/gt-america/GT-America-Condensed-Bold.woff2') format('woff2'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Condensed-Bold.woff') format('woff'), url('https://www.exploretock.com/fonts/gt-america/GT-America-Condensed-Bold.ttf') format('truetype'); } /* CLIENT-SPECIFIC RESET */ body, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; } /* Prevent WebKit and Windows mobile changing default text sizes */ table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; } /* Remove spacing between tables in Outlook 2007 and up */ img { -ms-interpolation-mode: bicubic; } /* Allow smoother rendering of resized image in Internet Explorer */ .im { color: inherit !important; } /* DEVICE-SPECIFIC RESET */ a[x-apple-data-detectors] { color: inherit !important; text-decoration: none !important; font-size: inherit !important; font-family: inherit !important; font-weight: inherit !important; line-height: inherit !important; } /* iOS BLUE LINKS */ /* RESET */ img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; display: block; } table { border-collapse: collapse; } table td { border-collapse: collapse; display: table-cell; } body { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; } /* BG COLORS */ .mainTable { background-color: #F0F0F0; } .mainTable--hospitality { background-color: #f7f2ed; } html { background-color: #F0F0F0; } /* VARIABLES */ .bg-white { background-color: white; } .hr { /* Cross-client horizontal rule. Adapted from https://litmus.com/community/discussions/4633-is-there-a-reliable-1px-horizontal-rule-method */ background-color: #d3d3d8; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; mso-line-height-rule: exactly; line-height: 1px; } .textAlignLeft { text-align: left !important; } .textAlignRight { text-align: right !important; } .textAlignCenter{ text-align: center !important; } .mt1 { margin-top: 6px; } .list { padding-left: 18px; margin: 0; } /* TYPOGRAPHY */ body { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 400; color: #4f4f65; -webkit-font-smoothing: antialiased; -ms-text-size-adjust:100%; -moz-osx-font-smoothing: grayscale; font-smoothing: always; text-rendering: optimizeLegibility; } .h1 { font-family: 'GT America Condensed Bold', 'Roboto Condensed', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 700; vertical-align: middle; font-size: 36px; line-height: 42px; } .h2 { font-family: 'GT America Medium', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 600; vertical-align: middle; font-size: 16px; line-height: 24px; } .text { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 400; font-size: 16px; line-height: 21px; } .text-list { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 400; font-size: 16px; line-height: 25px; } .textSmall { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 400; font-size: 14px; } .text-xsmall { font-family: 'GT America Regular', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-size: 11px; text-transform: uppercase; line-height: 22px; letter-spacing: 1px; } .text-bold { font-weight: 600; } .text-link { text-decoration: underline; } .text-linkNoUnderline { text-decoration: none; } .text-strike { text-decoration: line-through; } /* FONT COLORS */ .textColorDark { color: #23233e; } .textColorNormal { color: #4f4f65; } .textColorBlue { color: #2020c0; } .textColorGrayDark { color: #7B7B8B; } .textColorGray { color: #A5A8AD; } .textColorWhite { color: #FFFFFF; } .textColorRed { color: #df3232; } /* BUTTON */ .Button-primary-wrapper { border-radius: 3px; background-color: #2020C0; } .Button-primary { font-family: 'GT America Medium', 'Roboto', 'Helvetica', 'Arial', sans-serif; border-radius: 3px; border: 1px solid #2020C0; color: #ffffff; display: block; font-size: 16px; font-weight: 600; padding: 18px; text-decoration: none; } .Button-secondary-wrapper { border-radius: 3px; background-color: #ffffff; } .Button-secondary { font-family: 'GT America Medium', 'Roboto', 'Helvetica', 'Arial', sans-serif; border-radius: 3px; border: 1px solid #2020C0; color: #2020C0; display: block; font-size: 16px; font-weight: 600; padding: 18px; text-decoration: none; } /* LAYOUT */ .Content-container { padding-left: 60px; padding-right: 60px; } .Content-container--main { padding-top: 54px; padding-bottom: 60px; } .Content { width: 580px; margin: 0 auto; } .wrapper { max-width: 600px; } .section { padding: 24px 0px; border-bottom: 1px solid #d3d3d8; } .section--noBorder { padding: 24px 0px 0; } .section--last { padding: 24px 0px; } .message { background-color: #F4F4F5; padding: 18px; } .card { border: 1px solid #d3d3d8; padding: 18px; } /* HEADER */ .header-tockLogoImage { display: block; color: #F0F0F0; } .header-heroImage { padding-bottom: 24px; } /* PREHEADER */ .preheader { display: none; font-size: 1px; color: #FFFFFF; line-height: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; } /* BANNER */ .notice { padding: 12px; background: #23233E; color: #FFFFFF; display: block; font-size: 14px; font-family: 'GT America Medium', 'Roboto', 'Helvetica', 'Arial', sans-serif; font-weight: 600; } /* INTRO */ .section--intro { padding-bottom: 48px; } /* BOOKING INFO */ .business-logo__container { width: 48px; height: 48px; border-radius: 3px; border: 1px solid #d3d3d8; overflow: hidden; } .business-logo__image { border: 1px solid transparent; border-radius: 3px; width: 48px; height: 48px; display: block; } .business-address--address { width: 50%; } .business-address--map { width: 50%; } .business-address--map-image { width: 100%; } /* MOBILE TICKETS */ .mobile-ticket--description { width: 65%; margin-top: 12px; margin-right: 5%; } .mobile-ticket--code { width: 30%; } .mobile-ticket--code-image { width: 100%; } /* RESERVATION ACTIONS */ .linksTable { border-bottom: 1px solid #d3d3d8; } .linksTableRow { padding: 24px 12px; } .actions-icon { vertical-align: middle; } .actions-text { vertical-align: middle; } /* RECEIPT */ .receipt__container { border: 1px solid #d3d3d8; padding: 24px; } .receipt__row { border-top: 1px solid #d3d3d8; } /* FEEDBACK ICONS */ .feedback-link { border: 1px solid #d4d5da; border-radius: 3px; display: inline-block; width: calc(32% - 2px); padding: 10px 0; } .feedback-link-bumper { display: inline-block; width: 1%; } .feedback-link img { height: 50px; width: 50px; } /* SOCIAL ICONS */ .social-link { display: inline-block; width: auto; } .social-link-text { padding: 14px 24px 14px 14px; } /* TABLET STYLES */ @media screen and (max-width: 648px) { /* DEVICE-SPECIFIC RESET */ div[style*='margin: 16px 0;'] { margin: 0 !important; } /* ANDROID CENTER FIX */ /* LAYOUT */ .wrapper { width: 100% !important; max-width: 100% !important; } .Content { width: 90% !important; } .Content-container { padding-left: 36px !important; padding-right: 36px !important; } .Content-container--main { padding-top: 30px !important; padding-bottom: 42px !important; } .responsiveTable { width: 100% !important; } /* RESERVATION ACTIONS */ .linksTableRow { padding-left: 0 !important; padding-right: 0 !important; padding-top: 12px !important; padding-bottom: 12px !important; } .linksTableRow--borderRight { border-right: none !important; padding-left: 0 !important; padding-right: 0 !important; } /* FEEDBACK LINK */ .feedback-link img { height: 38px !important; width: 38px !important; } } /* MOBILE STYLES */ @media screen and (max-width: 480px) { /* TYPOGRAPHY */ .h1 { font-size: 30px !important; line-height: 30px !important; } .text { font-size: 16px !important; line-height: 22px !important; } /* BUTTON */ .mobile-buttonContainer { width: 100% !important; } /* LAYOUT */ .Content { width: 100% !important; } .Content-container { padding-left: 18px !important; padding-right: 18px !important; } .Content-container--main { padding-top: 24px !important; padding-bottom: 30px !important; } .section { padding: 18px 0 !important; } .section--last { padding: 18px 0 !important; } .header { padding: 0 18px !important; } .business-address--address { width: 100% !important; } .business-address--map { margin-top: 30px !important; width: 100% !important; } .mobile-ticket--description { width: 100% !important; margin-top: 0px !important; } .mobile-ticket--code { margin-top: 30px !important; margin-left: 0; width: 100% !important; } /* RECEIPT */ .receipt__container { padding: 12px !important; } /* SOCIAL ICONS */ .social-link { display: block !important; width: 100% !important; border-bottom: 1px solid #d3d3d8 !important; } /* INTRO */ .section--intro { padding-top: 18px !important; padding-bottom: 18px !important; } } </style> \n"
                + " </head> \n"
                + " <body style=\"margin: 0 !important; padding: 0 !important; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; height: 100%; margin: 0; padding: 0; width: 100%; font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-weight: 400; color: rgb(79, 79, 101); -webkit-font-smoothing: antialiased; -ms-text-size-adjust: 100%; -moz-osx-font-smoothing: grayscale; font-smoothing: always; text-rendering: optimizeLegibility;\"> \n"
                + "  <!-- EXTRA METADATA MARKUP --> \n"
                + "  <!--[if mso]>\n"
                + "    <style type=\"text/css\">\n"
                + ".h1 {font-family: 'Helvetica', 'Arial', sans-serif !important; font-weight: 700 !important; vertical-align: middle !important; font-size: 36px !important; mso-line-height-rule: exactly;line-height: 42px !important;}\n"
                + ".h2 {font-family: 'Helvetica', 'Arial', sans-serif !important;font-weight: 600 !important;vertical-align: middle !important;font-size: 16px !important;mso-line-height-rule: exactly;line-height: 24px !important;}\n"
                + ".text {font-family: 'Helvetica', 'Arial', sans-serif !important;font-weight: 400 !important;font-size: 16px !important;mso-line-height-rule: exactly;line-height: 21px !important;}\n"
                + ".text-list {font-family: 'Helvetica', 'Arial', sans-serif !important;font-weight: 400 !important;font-size: 16px !important;mso-line-height-rule: exactly;line-height: 25px !important;}\n"
                + ".textSmall {font-family: 'Helvetica', 'Arial', sans-serif !important;font-weight: 400 !important;font-size: 14px !important;}\n"
                + ".text-xsmall {font-family: 'Helvetica', 'Arial', sans-serif !important;font-size: 11px !important;text-transform: uppercase !important;mso-line-height-rule: exactly;line-height: 22px !important;letter-spacing: 1px !important;}\n"
                + ".text-bold {font-weight: 600 !important;}\n"
                + ".text-link {text-decoration: underline !important;}\n"
                + ".text-linkNoUnderline {text-decoration: none !important;}\n"
                + ".text-strike {text-decoration: line-through !important;}\n"
                + ".textColorDark {color: #23233e !important;}\n"
                + ".textColorNormal {color: #4f4f65 !important;}\n"
                + ".textColorBlue {color: #2020c0 !important;}\n"
                + ".textColorGray {color: #A5A8AD !important;}\n"
                + ".textColorWhite {color: #FFFFFF !important;}\n"
                + ".Button-primary {font-family: 'Helvetica', 'Arial', sans-serif !important;border-radius: 3px !important;border: 1px solid #2020C0 !important;color: #ffffff !important;display: block !important;font-size: 16px !important;font-weight: 600 !important;padding: 18px !important;text-decoration: none !important;}\n"
                + ".Button-secondary {font-family: 'Helvetica', 'Arial', sans-serif !important;border-radius: 3px !important;border: 1px solid #2020C0 !important;color: #2020C0 !important;display: block !important;font-size: 16px !important;font-weight: 600 !important;padding: 18px !important;text-decoration: none !important;}\n"
                + "    </style>\n"
                + "    <![endif]--> \n"
                + "  <!-- HIDDEN PREHEADER TEXT --> \n"
                + "  <div class=\"preheader\" style=\"display: none; font-size: 1px; color: rgb(255, 255, 255); line-height: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> \n"
                + "  </div> \n"
                + "  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\" mainTable  \" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; background-color: rgb(240, 240, 240);\"> \n"
                + "   <!-- HEADER --> \n"
                + "   <tr> \n"
                + "    <td align=\"center\" class=\"header\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\">\n"
                + "    <tr>\n"
                + "    <td align=\"center\" valign=\"top\" width=\"600\">\n"
                + "    <![endif]--> \n"
                + "     <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"Content\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 580px; margin: 0 auto;\"> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr> \n"
                + "       <td align=\"left\" valign=\"middle\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> </td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "     </table> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "    </td>\n"
                + "    </tr>\n"
                + "    </table>\n"
                + "    <![endif]--> </td> \n"
                + "   </tr> \n"
                + "   <!-- CONTENT --> \n"
                + "   <tr> \n"
                + "    <td align=\"center\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\">\n"
                + "    <tr>\n"
                + "    <td align=\"center\" valign=\"top\" width=\"600\">\n"
                + "    <![endif]--> \n"
                + "     <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"Content bg-white\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; background-color: white; width: 580px; margin: 0 auto;\"> \n"
                + "      <tr> \n"
                + "       <td class=\"Content-container Content-container--main text textColorNormal\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-weight: 400; font-size: 16px; line-height: 21px; color: rgb(79, 79, 101); padding-left: 60px; padding-right: 60px; padding-top: 54px; padding-bottom: 60px;\"> \n"
                + "        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse;\"> \n"
                + "         <tr> \n"
                + "          <td valign=\"top\" align=\"left\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "           <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse;\"> \n"
                + "            <tr> \n"
                + "             <td align=\"left\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> <span class=\"h1 textColorDark\" style=\"font-family: &quot;GT America Condensed Bold&quot;, &quot;Roboto Condensed&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-weight: 700; vertical-align: middle; font-size: 36px; line-height: 42px; color: rgb(35, 35, 62);\">Download Interview Invitation</span> </td> \n"
                + "            </tr> \n"
                + "            <tr class=\"spacer\"> \n"
                + "             <td height=\"18px\" colspan=\"2\" style=\"font-size: 18px; line-height:18px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "            </tr> \n"
                + "            <tr> \n"
                + "             <td align=\"left\" colspan=\"2\" valign=\"top\" width=\"100%\" height=\"1\" class=\"hr\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; background-color: rgb(211, 211, 216); border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; mso-line-height-rule: exactly; line-height: 1px;\">\n"
                + "              <!--[if gte mso 15]>&nbsp;<![endif]--></td> \n"
                + "            </tr> \n"
                + "            <tr class=\"spacer\"> \n"
                + "             <td height=\"18px\" colspan=\"2\" style=\"font-size: 18px; line-height:18px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "            </tr> \n"
                + "           </table> </td> \n"
                + "         </tr> \n"
                + "         <tr> \n"
                + "          <td valign=\"top\" align=\"left\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "           <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse;\"> \n"
                + "            <tr> \n"
                + "             <td align=\"left\" class=\"text textColorNormal\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-weight: 400; font-size: 16px; line-height: 21px; color: rgb(79, 79, 101);\"> Click button to preview the invitation. </td> \n"
                + "            </tr> \n"
                + "            <tr class=\"spacer\"> \n"
                + "             <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "            </tr> \n"
                + "            <tr class=\"spacer\"> \n"
                + "             <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "            </tr> \n"
                + "            <tr> \n"
                + "             <td align=\"center\" valign=\"center\" width=\"100%\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "              <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse;\"> \n"
                + "               <tr> \n"
                + "                <td align=\"center\" valign=\"center\" width=\"100%\" class=\"Button-primary-wrapper\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; border-radius: 3px; background-color: rgb(32, 32, 192);\"> <a href=\"http://localhost:8084/Penempatan/invitationservlet?id="+id+"\" target=\"_blank\" class=\"Button-primary\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; font-family: &quot;GT America Medium&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; border-radius: 3px; border: 1px solid rgb(32, 32, 192); color: rgb(255, 255, 255); display: block; font-size: 16px; font-weight: 600; padding: 18px; text-decoration: none;\"> Preview </a> </td> \n"
                + "               </tr> \n"
                + "              </table> </td> \n"
                + "            </tr> \n"
                + "           </table> </td> \n"
                + "         </tr> \n"
                + "        </table> </td> \n"
                + "      </tr> \n"
                + "     </table> </td> \n"
                + "   </tr> \n"
                + "   <!-- FOOTER --> \n"
                + "   <tr> \n"
                + "    <td align=\"center\" class=\"Content\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell; width: 580px; margin: 0 auto;\"> \n"
                + "     <!-- Will most likely required a feature flag --> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\">\n"
                + "<tr>\n"
                + "<td align=\"center\" valign=\"top\" width=\"600\">\n"
                + "<![endif]--> \n"
                + "     <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"Content-container\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; padding-left: 60px; padding-right: 60px;\"> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr> \n"
                + "       <td align=\"center\" valign=\"top\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> <a href=\"https://www.metrodata.co.id/\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\"> <img src=\"https://images.glints.com/unsafe/1024x0/glints-dashboard.s3.amazonaws.com/company-logo/cf7b623f8414e3edc674eacbe49160c8.png\" width=\"30\" height=\"30\" alt=\"Tock\" border=\"0\" style=\"-ms-interpolation-mode: bicubic; border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; display: block;\" /> </a> </td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"18px\" colspan=\"2\" style=\"font-size: 18px; line-height:18px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr> \n"
                + "       <td align=\"center\" style=\"-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\"> \n"
                + "        <div class=\"text-xsmall textColorNormal\" style=\"font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-size: 11px; text-transform: uppercase; line-height: 22px; letter-spacing: 1px; color: rgb(79, 79, 101);\">\n"
                + "         © 2019 PT Metrodata Electronics, Tbk.\n"
                + "        </div> \n"
                + "        <div class=\"text-xsmall textColorNormal\" style=\"font-family: &quot;GT America Regular&quot;, &quot;Roboto&quot;, &quot;Helvetica&quot;, &quot;Arial&quot;, sans-serif; font-size: 11px; text-transform: uppercase; line-height: 22px; letter-spacing: 1px; color: rgb(79, 79, 101);\">\n"
                + "         All Rights Reserved\n"
                + "        </div> </td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "      <tr class=\"spacer\"> \n"
                + "       <td height=\"12px\" colspan=\"2\" style=\"font-size: 12px; line-height:12px; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; display: table-cell;\">&nbsp;</td> \n"
                + "      </tr> \n"
                + "     </table> \n"
                + "     <!--[if (gte mso 9)|(IE)]>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "<![endif]--> </td> \n"
                + "   </tr> \n"
                + "  </table> \n"
                + " \n"
                + "</body> \n"
                + "</html>", subjek = "Interview Invitation, " + name + "!";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mii.bootcamp29@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subjek);
            message.setContent(pesan, "text/html");

            Transport.send(message);
            System.out.println("done");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
