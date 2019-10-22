Feature: Validacao de Placas

Scenario: Consultar uma placa invalida e validar
Given O Aplicativo estar aberto na primeira pagina
And Clicar na pagina inicial
And Informar a placa invalida
And clicar no botao pesquisar
Then Receber a mensagem de erro