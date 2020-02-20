import static def.jquery.Globals.$;
import static def.dom.Globals.window;


import def.dom.HTMLElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlAnchor;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlButton;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlDiv;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlForm;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlImg;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlInput;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlLabel;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlP;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlSpan;
import it.uniroma1.fabbricasemanticajsweet.dom.HtmlTextArea;

/**
 * Represents the DefinitionAnnotation task HTML page.
 */
public class DefinitionAnnotation {

  /**
   * Represents the url of the Home page.
   */
  public static final String HOME_URL = "home.html";

  /**
   * Represents the url of the LogoutServlet.
   */
  public static final String LOGOUT_URL = "logout.jsp";

  /**
   * Represents the path of the logo.
   */
  public static final String LOGO = "images/FS.svg";

  /**
   * Represents the url of the NewExampleServiceServlet.
   */
  public static final String REST_URL = "nextExample.jsp";

  /**
   * Represents the url of the DefinitionAnnotationServlet.
   */
  public static final String TASK_URL = "definitionAnnotation.jsp";

  /**
   * Represents the url of the AuthenticationServiceServlet.
   */
  public static final String LOGIN_CHECK = "isLoggedIn.jsp";

  /**
   * Represents the url of the NextTaskServlet.
   */
  public static final String NEXT_TASK = "nextTask.jsp";

  /**
   * Represents the url of the Login page.
   */
  public static final String LOGIN_URL = "login.html";

  /**
   * Constructs the HTML page.
   * @param word     [Represents the word of the task]
   * @param hypernym [Represents the hypernym of the task]
   */
  public static HTMLElement page(String word, String  hypernym) {
    return HtmlDiv.newBuilder()
      .append(
        HtmlDiv.newBuilder()
          .setClass("row lightBrown navb valign-wrapper")
          .append(
            HtmlDiv.newBuilder()
              .setClass("col s6")
              .append(
                HtmlImg.newBuilder()
                  .setClass("imgS")
                  .setSrc(LOGO)
              )
          )
          .append(
            HtmlDiv.newBuilder()
              .setClass("col s6 right-align")
              .append(
                HtmlAnchor.newBuilder()
                  .setClass("waves-effect btn-flat brownie")
                  .setHref(HOME_URL)
                  .setContent("HOME")
              )
              .append(
                HtmlAnchor.newBuilder()
                  .setClass("waves-effect btn-flat brownie")
                  .setHref(LOGOUT_URL)
                  .setContent("logout")
              )
          )
      )
      .append(
        HtmlDiv.newBuilder()
          .setClass("container")
          .append(
            HtmlDiv.newBuilder()
              .setClass("valign-wrapper h80")
              .append(
                HtmlDiv.newBuilder()
                  .setClass("row")
                  .append(
                    HtmlDiv.newBuilder()
                      .setClass("center-align")
                      .append(
                        HtmlDiv.newBuilder()
                          .setClass("fontW marginTop")
                          .append(
                            HtmlP.newBuilder()
                              .setContent("Data la seguente parola ed il suo iperonimo, inserisci la sua definizione nella tua lingua madre:")
                          )
                      )
                      .append(
                        HtmlDiv.newBuilder()
                          .setClass("col s12")
                          .append(
                            HtmlDiv.newBuilder()
                              .setClass("card yellow-card marginTB")
                              .append(
                                HtmlDiv.newBuilder()
                                  .setClass("card-content center-align white-text")
                                  .append(
                                    HtmlSpan.newBuilder()
                                      .setClass("card-title")
                                      .setContent(word.toUpperCase())
                                  )
                                  .append(
                                    HtmlP.newBuilder()
                                      .setClass("fontP")
                                      .setContent(hypernym)
                                  )
                              )
                          )
                          .append(
                            HtmlForm.newBuilder()
                              .setClass("col s12 marginT")
                              .setMethod("POST")
                              .setAction(TASK_URL)
                              .append(
                                HtmlDiv.newBuilder()
                                  .setClass("row")
                                  .append(
                                    HtmlDiv.newBuilder()
                                      .setClass("input-field col s12")
                                      .append(
                                        HtmlTextArea.newBuilder()
                                          .setName("definition")
                                          .setId("textarea1")
                                          .setClass("materialize-textarea")
                                          .setRequired(true)
                                      )
                                      .append(
                                        HtmlLabel.newBuilder()
                                          .setFor("textarea1")
                                          .setContent("Definizione")
                                      )
                                  )
                                  .append(
                                    HtmlDiv.newBuilder()
                                      .setClass("col s12 marginT")
                                      .append(
                                        HtmlButton.newBuilder()
                                          .setClass("btn waves-effect waves-light greenie")
                                          .setType("submit")
                                          .setContent("AVANTI")
                                      )
                                  )
                                  .append(
                                    HtmlDiv.newBuilder()
                                      .setClass("col s12")
                                      .append(
                                        HtmlAnchor.newBuilder()
                                          .setClass("waves-effect waves-light btn white brownie skipPAD")
                                          .setContent("SALTA")
                                          .setHref(NEXT_TASK)
                                      )
                                  )
                                  .append(
                                    HtmlInput.newBuilder()
                                      .setName("word")
                                      .setHidden(true)
                                      .setValue(word)
                                  )
                                  .append(
                                    HtmlInput.newBuilder()
                                      .setName("hypernym")
                                      .setHidden(true)
                                      .setValue(hypernym)
                                  )
                              )
                          )
                      )
                  )
              )
          )
      ).build();
  }


  public static void main(String[] args) {
    $.get(LOGIN_CHECK, (Object result, String a, JQueryXHR ctx) -> {
      String isLoggedIn = result.toString();
      if (isLoggedIn.equals("false")) {
        window.location.replace(LOGIN_URL);
      }
      return null;
    });
    
    $.getJSON(REST_URL, "task=DEFINITION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
      JSON json = (JSON) result;
      String word = json.$get("word");
      String hypernym = json.$get("hypernym");
      HTMLElement page = DefinitionAnnotation.page(word, hypernym);
      $("body").append(page);
      return null;
    });
  }
}