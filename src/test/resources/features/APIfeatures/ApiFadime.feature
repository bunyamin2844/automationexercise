Feature:Response Kodun 405 olduğunu ve Response mesajı doğrulayın

  Scenario:Delete islemi
    Given Kullanici pathParams olusturur.
   # Then Kullanici expected Data yi olusturur.
    And Kullanici Delete islemi gonderir ve yanit alir.
    Then Kullanici Delete islemi icin Api verilerini dogrular.
