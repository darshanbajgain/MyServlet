# Servlet Form Processing with Cookie Handling
This repository contains a simple Java servlet project that demonstrates form processing and cookie handling.
The project includes two servlets (ServletClass and Servlet2) designed to process user input from an HTML form and showcase the use of cookies.

## Program Structure
The program structure is as follows:

- ServletClass: This servlet handles the initial form submission, reads the username from the form, and creates a cookie (name) with the username. It then displays a confirmation message along with a button to submit the form data to Servlet2.

- Servlet2: This servlet retrieves the username from the cookie created by ServletClass and displays it. This servlet is triggered when the button in the confirmation page is clicked.

- index.html: The HTML form that collects the username and password.

## Usage
1. Build and Deploy: Build the project and deploy it to a servlet container (e.g., Apache Tomcat).

2. Access the Form: Open the form in a web browser by navigating to http://localhost:8080/YourWebAppName/index.html.

3. Submit Form: Enter a username and password in the form and click the "Submit" button.

4. Confirmation Page: After submitting the form, you will see a confirmation page with the submitted username and a button to proceed to Servlet2.

5. Cookie Handling: ServletClass creates a cookie with the username, and Servlet2 retrieves and displays the username from the cookie.

## Important Notes
- The project uses servlet annotations for URL mapping (@WebServlet) to define the servlet mappings.

- Cookies are utilized for simple data transfer between servlets. The Cookie class is used to create and retrieve cookies.

- This is a basic example intended for educational purposes. In a real-world scenario, proper security measures and validation checks should be implemented.

### Below are snippets of the code that specifically handles cookies in your ServletClass and Servlet2 servlets.

**ServletClass - Cookie Creation**

```java
@WebServlet("/ServletClass")
public class ServletClass extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read form data using getParameter()
        String username = request.getParameter("userName");

        // Create a new cookie with the username
        Cookie nameCookie = new Cookie("name", username);

        // Add the cookie to the response
        response.addCookie(nameCookie);
    }
}

```
Explanation:
Cookie nameCookie = new Cookie("name", username);: This line creates a new Cookie object named "name" with the value of the submitted username.
response.addCookie(nameCookie);: This line adds the cookie to the response. The client's browser will receive and store this cookie for subsequent requests.

**Servlet2 - Cookie Retrieval**

```java
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve cookies from the request
        Cookie[] cookies = request.getCookies();

        // Check if cookies exist
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Check if the cookie is the one we created in ServletClass
                if (cookie.getName().equals("name")) {
                    String usernameFromCookie = cookie.getValue();
                    
                    // Use the usernameFromCookie as needed
                }
            }
        }
    }
}

```
Explanation:
Cookie[] cookies = request.getCookies();
This line retrieves an array of cookies from the client's request.
for (Cookie cookie : cookies) { ... }: 
This loop iterates through the cookies.
if (cookie.getName().equals("name")) { ... }: 
This condition checks if the current cookie has the name "name" (the name created in ServletClass).
String usernameFromCookie = cookie.getValue();: 
If the cookie is found, this line retrieves the value of the cookie, which is the username set in ServletClass. You can use usernameFromCookie as needed in your servlet logic.

These snippets illustrate the creation of a cookie in ServletClass and the retrieval of cookies in Servlet2. Cookies provide a way to store small pieces of information on the client's browser, allowing you to maintain state between multiple requests from the same client.


