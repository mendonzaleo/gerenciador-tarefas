<h1>Gerenciador de Tarefas</h1>

<sub>Gerenciador de tarefas com JSF</sub>

<p>Infelizmente não consegui concluir o projeto a tempo, pois tive algumas dificuldades com a configuração do servidor, e a integração com a implementação primefaces, o que me atrasou.</p>
<p>A seguir os passos para a execução do projeto no estado atual.</p>
<ul>
  <il>Wildfly Server versão 33.0.1.Final</il>
  <il>PostgreSQL versão 42.7.3</il>
  <il>JDK 17</il>
</ul>
<p>Para funcionar a implementação do postgreSQL deve ser criado um datasource no servidor, isso pode ser feito através do console web, acessando o endereço localhost:9990/console. Para conseguir acessar o console é necessário configurar um usuário através do prompt de comando.</p>
<p>Após acessar o console é necessário adicionar o driver JDBC do postgres a basta Wildfly 33.0.1.Final/standalone/deployments para que o servidor reconheça o driver do postgres</p>
<p>Enfim, para executar o projeto deve executado o comando mvn package para empacotar o projeto, ele vai aparecer na pasta target, basta mover o arquivo .war para a pasta Wildfly 33.0.1.Final/standalone/deployments. Após fazer isso é só iniciar o servidor e tentar acessar o endereço localhost:8080/mgn-task/index.xhtml.</p>
