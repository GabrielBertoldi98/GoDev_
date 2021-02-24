Documentação

Projeto realizado utilizando a linguagem JAVA através da IDE Eclipse. Autor: Gabriel Bertoldi Inácio

Todo o processo do sistema gira em torno de métodos vindo de uma classe Interface no qual cada método, com exceção dos métodos de pesquisas, fazem valores entrarem e sairem de listas. O tamanho das salas de aulas assim como o tamanho das áreas de café informadas pelo usuário, definirá o tamanho máximo de dois ArrayLists para cada área, dois para a área de aula e dois para a área de café, sendo definidos através de contadores. O sistema possui uma sequencia de métodos que devem ser utilizados, caso utilize um método erroniamente será disparado uma exceção explicando o que fazer e o programa irá se encerrar (abaixo se encontra a lista de métodos e a sequencia correta).

O cadastro de alunos deverá ser realizado através do método cadastrarAluno(nome, sobrenome), aonde através deste método as listas da sala de aula serão preenchidos de acordo com a ordem dos cadastros dos alunos. O segundo arrayList da turma será preenchido apenas se o primeiro arrayList chegar ao limite. Após utilizar o método tomarCafe() todo o conteúdo dos arrayList's das turmas será transferido para os arrayList's da cafeteria. Caso informe um espaço menor do que o total de alunos cadastrados, o sistema não irá encerrar, ele apenas irá transferir os alunos para a cafeteria até a capacidade dela ser atingida, o restante dos alunos permanecerão nas listas das turmas.

Ao utilizar o método voltarAula() todo o conteudo que os arrayList's das cafeterias possuem, serão transferidos para um outro arrayList através do método juntarAlunos() no qual se encontra privado. Para cada aluno que é transferido, o seu respectivo lugar na cafeteria é excluido. Após todos os alunos serem transferidos para este arrayList, é utilizado o método Shuffle no qual mistura os alunos, assim quando retornarem para sala de aula estarão em turmas diferentes. Lembrando que apenas os valores que forem transferidos para os arrayList's das cafeterias sofrerão este processo.

O sistema possui dois métodos de pequisa, o primeiro método é o pesquisarSala() no qual é apresentado ao usuário um menu numérico através do terminal, no qual o usuário pode optar para ver as salas de aula, e as praças de alimentação. E o outro método é o pesquisarPessoa() no qual é apresentado um menu através do terminal, no qual o usuário pode optar por pesquisar pelo nome completo do aluno, ou pesquisar apenas pelo nome ou sobrenome. Caso o banco de dados não possua nenhum aluno que coencide com a pesquisa, será mostrado uma mensagem informando que nenhum aluno foi encontrado, porem o sistema não irá encerrar, assim o usuário poderá fazer mais de uma pesquisa por vez.

Foram feitos testes alterando a capacidade de alunos, e a capacidade da cafeteria, e após a utilização dos métodos tomarCafe() e voltarAula() várias vezes, foi utilizado os métodos de pesquisa para ter certeza que estavão retornando o local correto dos alunos e a situação de cada arrayList.

COMPILAR

Eclipse - Baixe o .rar GoDev e o extraia para uma pasta de sua preferencia, e no ambiente Eclipse vá em: File -> Open Projects from file System -> Clique em Directory -> Selecione a pasta contendo o projeto e clique em selecionar pasta. Após fazer isto o projeto será aberto no Eclipse.

Netbeans - Baixe o .rar GoDev e o extraia para uma pasta de sua preferencia, e no ambient Netbeans vá em: File -> Import Project -> Eclipse Project -> Selecione a opção Import Project ignoring Project Dependencies, após você escolher está opção você clica no primeiro Browse e seleciona a pasta GoDev, após fazer isto você deve clicar no segundo Browse e selecionar uma pasta para onde o seu projeto do netbeans deverá ser direcionado. Após fazer isto o projeto será aberto no Netbeans.

LISTA DE MÉTODOS

cadastrarAlunos(nome, sobrenome)

cadastrarSala(nome, lotação)

cadastrarCafe(nome, lotação)

tomarCafe()

voltarAula()

Os métodos de pesquisa podem ser utilizados em qualquer ordem

pesquisarAluno()

pesquisarSala()
