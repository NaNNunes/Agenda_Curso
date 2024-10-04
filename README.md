#  Tutorial Vincular Branch Producao
- Branch producao será a branch para commits de projetos a serem alterados ou inacabados.
---

### Apos o processo de vinculação repositorio remoto com repositorio local
Use o comando:
- git remote add origin producao https://github.com/NaNNunes/Agenda_Curso.git \
Você devera ter dois branch remotos apos o comando acima.

### Para verificar use o comando:
- git remote -v \
Que deverá retornar:\
origin https://github.com/NaNNunes/Agenda_Curso.git (fetch) \
origin https://github.com/NaNNunes/Agenda_Curso.git (push) \
producao  https://github.com/NaNNunes/Agenda_Curso.git (fetch) \
producao https://github.com/NaNNunes/Agenda_Curso.git (push) 
---

## No repositorio local
Use o comando:
- git branch producao\
Que criará uma branch local com o nome producao\
Nela sera feita commits para a branch remota producao

#### Para verifica as branches locais use o comando:
- git branch\
  Que deverá retornar, se copiados todos os passos até então:\
   \* main \
  producao\
  ###### O '*' representa sua branch atual
---

## Interação com remote branch
Antes de qualquer commit, é necessário alternar a branch local para enviar atualizações para a branch remota "respectiva", para isso use:
- git checkout producao/main - Alterará para a branch local informada
###### PS: branch diferentes são como pastas/diretorios diferente, chamadas de branches, ramificações por terem um ponto em comum no histórico do repositório. Em resumo uma branch pode não ter todos os arquivos de outra branch.
O comando deverá retornar algo como: \
Switched to branch 'nome da branch selecionada'
...

## Para push e pull será necessário informa qual é a branch remota de destino
Para isso use, estando na 'respectiva' branch local:
- git push origin producao/main - para enviar commit para producao ou para main
- git pull origin producao/main - para trazer atualizações da branch remota, producao ou main  
