# Estrutura para testes
Documentação Automação de Casos de Testes Java/Cucumber

Resumo: 
Desenvolvimento do escopo para automação de casos de testes utilizado a técnica BDD (Behavior Driven Development) ou Design/Desenvolvimento guiado por comportamento, no caso não será utilizado a técnica com a proposta a que foi criada, mais para gerar relatórios a partir de casos de testes criados pelo analista de testes, porém a técnica em si tem como premissa envolver analista de negócios escrevendo cenários antes do desenvolvimento, portanto em nosso escopo iremos desenvolver cenários(histórias) a partir de funcionalidades já criadas ao final gerar um relatório de testes executados e seus status.

# Ferramentas utilizadas:
**IDE de desenvolvimento:** Eclipse

# Frameworks: 
- **Maven** – controle de versões.
- **Cucumber** – responsável interação das histórias com desenvolvimento.
- **Selenium Webdriver** – responsável pela manipulação de elementos Web.
- **Apache POI** – responsável pela manipulação de planilhas Excel.
- **Junit** -  indicado para criação de testes Unitários.
- **ExtentReports** – responsável pela geração de relatório Html das execuções.

# Estrutura de pastas utilizadas:
O projeto contém a seguinte estrutura
- **Locators** – Armazena arquivos dos elementos mapeados da tela.
- **Pages** – Armazena arquivos responsáveis pelas interações dos elementos mapeados.
- **Steps** – Armazena arquivos gerados a partir das features criadas, fazendo a chamada das pages.
- **RunTest**
	- **TestRule**(Regras de Testes) – são feitas a configurações de execução.
	- **Utils** – utilizado para armazenar métodos reutilizáveis.
	- **Exceções** -  casos seja usado são montados todos tratamento de exceções.
 	- **TestRunner** – configuração de chamada da feature para execução.

# Configuração Ambiente: 
- Instalar ambiente de desenvolvimento java.
- Instalar ambiente Maven “https://maven.apache.org/download.cgi”.
- Instalação Cucumber:
  - Clicar menu Help/ Install New Software
	- Digitar Work With: 
      “https://cucumber.io/cucumber-eclipse/update-site ”
  - Adicionar dependências no arquivo “pom.xml”.
  versões utilizadas na data da criação desta estrutura (26/12/2018).
    - cucumber-java - 1.2.5
    - selenium-java - 3.141.59
    - cucumber-junit - 1.2.5
    - extentreports - 4.0.5
    - poi - 4.0.1
    - commons-io - 2.6
  

