FROM node:22-alpine
WORKDIR /app/frontend
COPY package.json .
RUN yarn
COPY . .
EXPOSE 3000
CMD [ "yarn", "dev" ]