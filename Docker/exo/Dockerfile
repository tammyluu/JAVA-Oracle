FROM nginx
 
RUN apt update
 
RUN apt -y install git
 
WORKDIR /usr/share/nginx
 
RUN rm -rf html
 
RUN git clone https://github.com/gabrielecirulli/2048.git /usr/share/nginx/html
 
EXPOSE 80


#docker build -t jeu-2048 .
# docker ps
# docker run -d --name jeu-2048-container -p 8080:80 jeu-2048
# docker run -d --name jeu2-2048-container -p 8081:80 jeu-2048
# docker stop jeu-2048-container
# docker stop jeu2-2048-container
# docker start jeu2-2048-container
# docker stop jeu2-2048-container
# docker rm jeu-2048-container jeu2-2048-container
# docker ps