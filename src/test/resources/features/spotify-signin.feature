Feature: Spotify sign in page

  Background:
    Given the home page is opened
      # And the Cookie disclaimer is closed
      And the Bejelentkezés header button is clicked

  @requiredfield
  Scenario: Check required fields
    When the Bejelentkezés button is clicked
    Then the 'Helytelen felhasználónév vagy jelszó.' error message of the 'E-mail cím vagy felhasználónév' field should be shown
    And the 'Helytelen felhasználónév vagy jelszó.' error message of the 'Jelszó' field should be shown

  Scenario Outline: Check the fields with invalid parameters
    When the '<field>' is filled in with '<parameter>'
    And the Tab button is pressed
    Then the '<errorMessage>' error message of the '<field>' field should be shown

    Examples:
      | field                          | parameter | errorMessage                          |
      | E-mail cím vagy felhasználónév | asd       | Helytelen felhasználónév vagy jelszó. |
      | E-mail cím vagy felhasználónév | 123       | Helytelen felhasználónév vagy jelszó. |
      | E-mail cím vagy felhasználónév | aaa123    | Helytelen felhasználónév vagy jelszó. |
      | Jelszó                         | asd       | Helytelen felhasználónév vagy jelszó. |
      | Jelszó                         | 123       | Helytelen felhasználónév vagy jelszó. |
      | Jelszó                         | aaa123    | Helytelen felhasználónév vagy jelszó. |

  Scenario: Check invalid login name and password
    When the 'E-mail cím vagy felhasználónév' is filled in with 'valaki@gmail.com'
    And the 'Jelszó' is filled in with 'asdasd123'
    And the Tab button is pressed
    Then the 'Helytelen felhasználónév vagy jelszó.' error message of the 'E-mail cím vagy felhasználónév' field should be shown

  Scenario: Check valid login name and invalid password
    When the 'E-mail cím vagy felhasználónév' is filled in with 'szoft.teszt00@gmail.com'
    And the 'Jelszó' is filled in with 'asdasd123'
    And the Tab button is pressed
    Then the 'Helytelen felhasználónév vagy jelszó.' error message of the 'Jelszó' field should be shown

  Scenario: Check valid login name and password
    When the 'E-mail cím vagy felhasználónév' is filled in with 'szoft.teszt00@gmail.com'
    And the 'Jelszó' is filled in with 'teszt1234'
    And the Tab button is pressed
    Then navigate Main page