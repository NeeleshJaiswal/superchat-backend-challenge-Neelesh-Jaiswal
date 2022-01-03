INSERT INTO channels (name) VALUES ('WhatsApp');
INSERT INTO channels (name) VALUES ('Facebook Messenger');
INSERT INTO channels (name) VALUES ('E-Mail');
INSERT INTO channels (name) VALUES ('SMS');
INSERT INTO channels (name) VALUES ('Telegram');

INSERT INTO clients (address, name, phone_number) VALUES ('2101, Skybay, India', 'BISS45', '+917828386828');

INSERT INTO contacts (email, first_name, last_name, phone_number, channel_id) VALUES ('janedoe@gmail.com', 'Jane', 'Doe', '+9199999999995', 1);
INSERT INTO contacts (email, first_name, last_name, phone_number, channel_id) VALUES ('johndoe@hotmail.com', 'John', 'Doe', '+9188877667766', 2);

INSERT INTO message_sender (type) VALUES ('User');
INSERT INTO message_sender (type) VALUES ('Contact');

INSERT INTO message_status (name) VALUES ('Sent');
INSERT INTO message_status (name) VALUES ('Delivered');
INSERT INTO message_status (name) VALUES ('Read');

INSERT INTO users (firstname, lastname, client_id) VALUES ('Neelesh', 'Jaiswal', 1);
INSERT INTO users (firstname, lastname, client_id) VALUES ('Aafreen', 'Khan', 2);