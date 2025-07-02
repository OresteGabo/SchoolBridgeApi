-- Insert initial roles

INSERT INTO roles (description, db_name) VALUES
                                             ('School Admin', 'SCHOOL_ADMIN'),
                                             ('Parent', 'PARENT'),
                                             ('Teacher', 'TEACHER'),
                                             ('Student', 'STUDENT'),
                                             ('Guest', 'GUEST');

-- Insert districts
INSERT INTO districts (name) VALUES
                                 ('Gasabo'), ('Kicukiro'), ('Nyarugenge');

-- Insert banks
INSERT INTO banks (name, abbrev_name) VALUES
                                          ('Bank of Kigali', 'BK'),
                                          ('Equity Bank', 'EB'),
                                          ('I&M Bank', 'IM');

INSERT INTO users
(family_name, first_name, user_name, password_hash, date_of_birth, email, gender, created_at)
VALUES
--  1 – 20
('Uwimana','Jean','jean.uwimana1','pass001','1982-04-15','jean.uwimana1@example.com','MALE',NOW()),
('Mukamana','Alice','alice.mukamana2','pass002','1990-07-22','alice.mukamana2@example.com','FEMALE',NOW()),
('Nshimiyimana','Eric','eric.nshimiyimana3','pass003','1979-11-30','eric.nshimiyimana3@example.com','MALE',NOW()),
('Bizimana','Sandrine','sandrine.bizimana4','pass004','1994-05-20','sandrine.bizimana4@example.com','FEMALE',NOW()),
('Niyonsaba','Patrick','patrick.niyonsaba5','pass005','1987-08-17','patrick.niyonsaba5@example.com','MALE',NOW()),
('Habimana','Beata','beata.habimana6','pass006','1975-12-11','beata.habimana6@example.com','FEMALE',NOW()),
('Ishimwe','Emmanuel','emmanuel.ishimwe7','pass007','1985-03-27','emmanuel.ishimwe7@example.com','MALE',NOW()),
('Uwase','Clarisse','clarisse.uwase8','pass008','1991-09-03','clarisse.uwase8@example.com','FEMALE',NOW()),
('Nyiransabimana','Theoneste','theoneste.nyiransabimana9','pass009','1980-06-14','theoneste.nyiransabimana9@example.com','MALE',NOW()),
('Mugisha','Angelique','angelique.mugisha10','pass010','1995-01-29','angelique.mugisha10@example.com','FEMALE',NOW()),
('Ndayambaje','Fabrice','fabrice.ndayambaje11','pass011','1988-10-03','fabrice.ndayambaje11@example.com','MALE',NOW()),
('Uwitonze','Aline','aline.uwitonze12','pass012','1992-04-25','aline.uwitonze12@example.com','FEMALE',NOW()),
('Mukazayire','Claude','claude.mukazayire13','pass013','1977-09-15','claude.mukazayire13@example.com','MALE',NOW()),
('Rukundo','Eliane','eliane.rukundo14','pass014','1993-11-06','eliane.rukundo14@example.com','FEMALE',NOW()),
('Ndizeye','Blaise','blaise.ndizeye15','pass015','1986-07-19','blaise.ndizeye15@example.com','MALE',NOW()),
('Ndayisaba','Josiane','josiane.ndayisaba16','pass016','1991-02-21','josiane.ndayisaba16@example.com','FEMALE',NOW()),
('Munyaneza','Jean-Paul','jeanpaul.munyaneza17','pass017','1983-05-13','jeanpaul.munyaneza17@example.com','MALE',NOW()),
('Habyarimana','Christine','christine.habyarimana18','pass018','1990-08-30','christine.habyarimana18@example.com','FEMALE',NOW()),
('Niyitegeka','Denis','denis.niyitegeka19','pass019','1976-12-01','denis.niyitegeka19@example.com','MALE',NOW()),
('Manirakiza','Aline','aline.manirakiza20','pass020','1989-03-11','aline.manirakiza20@example.com','FEMALE',NOW());

INSERT INTO users
(family_name, first_name, user_name, password_hash, date_of_birth, email, gender, created_at)
VALUES

-- 21 – 40
('Uwimana','Pascal','pascal.uwimana21','pass021','1984-06-27','pascal.uwimana21@example.com','MALE',NOW()),
('Mukamana','Jeannette','jeannette.mukamana22','pass022','1991-01-05','jeannette.mukamana22@example.com','FEMALE',NOW()),
('Nshimiyimana','David','david.nshimiyimana23','pass023','1987-09-19','david.nshimiyimana23@example.com','MALE',NOW()),
('Bizimana','Esther','esther.bizimana24','pass024','1992-11-23','esther.bizimana24@example.com','FEMALE',NOW()),
('Niyonsaba','Alex','alex.niyonsaba25','pass025','1985-04-18','alex.niyonsaba25@example.com','MALE',NOW()),
('Habimana','Suzanne','suzanne.habimana26','pass026','1988-08-07','suzanne.habimana26@example.com','FEMALE',NOW()),
('Ishimwe','Benoit','benoit.ishimwe27','pass027','1979-05-12','benoit.ishimwe27@example.com','MALE',NOW()),
('Uwase','Marie','marie.uwase28','pass028','1994-02-20','marie.uwase28@example.com','FEMALE',NOW()),
('Nyiransabimana','Eric','eric.nyiransabimana29','pass029','1982-10-30','eric.nyiransabimana29@example.com','MALE',NOW()),
('Mugisha','Clarisse','clarisse.mugisha30','pass030','1986-07-03','clarisse.mugisha30@example.com','FEMALE',NOW()),
('Ndayambaje','Emmanuel','emmanuel.ndayambaje31','pass031','1989-11-17','emmanuel.ndayambaje31@example.com','MALE',NOW()),
('Uwitonze','Sandrine','sandrine.uwitonze32','pass032','1990-03-08','sandrine.uwitonze32@example.com','FEMALE',NOW()),
('Mukazayire','Pascaline','pascaline.mukazayire33','pass033','1987-12-25','pascaline.mukazayire33@example.com','FEMALE',NOW()),
('Rukundo','Alex','alex.rukundo34','pass034','1984-05-29','alex.rukundo34@example.com','MALE',NOW()),
('Ndizeye','Josiane','josiane.ndizeye35','pass035','1991-08-10','josiane.ndizeye35@example.com','FEMALE',NOW()),
('Ndayisaba','Claude','claude.ndayisaba36','pass036','1982-01-14','claude.ndayisaba36@example.com','MALE',NOW()),
('Munyaneza','Aline','aline.munyaneza37','pass037','1985-09-28','aline.munyaneza37@example.com','FEMALE',NOW()),
('Habyarimana','Eric','eric.habyarimana38','pass038','1978-04-06','eric.habyarimana38@example.com','MALE',NOW()),
('Niyitegeka','Beatrice','beatrice.niyitegeka39','pass039','1993-07-21','beatrice.niyitegeka39@example.com','FEMALE',NOW()),
('Manirakiza','Pascal','pascal.manirakiza40','pass040','1987-11-05','pascal.manirakiza40@example.com','MALE',NOW());

INSERT INTO users
(family_name, first_name, user_name, password_hash, date_of_birth, email, gender, created_at)
VALUES
-- 41 – 60
('Uwimana','Jean-Claude','jeanclaude.uwimana41','pass041','1983-02-12','jeanclaude.uwimana41@example.com','MALE',NOW()),
('Mukamana','Suzanne','suzanne.mukamana42','pass042','1990-06-14','suzanne.mukamana42@example.com','FEMALE',NOW()),
('Nshimiyimana','Fabrice','fabrice.nshimiyimana43','pass043','1985-08-19','fabrice.nshimiyimana43@example.com','MALE',NOW()),
('Bizimana','Fabrice','fabrice.bizimana44','pass044','1977-03-23','fabrice.bizimana44@example.com','MALE',NOW()),
('Niyonsaba','Alice','alice.niyonsaba45','pass045','1991-05-30','alice.niyonsaba45@example.com','FEMALE',NOW()),
('Habimana','Jean','jean.habimana46','pass046','1986-09-22','jean.habimana46@example.com','MALE',NOW()),
('Ishimwe','Patrick','patrick.ishimwe47','pass047','1988-01-16','patrick.ishimwe47@example.com','MALE',NOW()),
('Uwase','Clarisse','clarisse.uwase48','pass048','1990-10-29','clarisse.uwase48@example.com','FEMALE',NOW()),
('Nyiransabimana','Emmanuel','emmanuel.nyiransabimana49','pass049','1982-12-04','emmanuel.nyiransabimana49@example.com','MALE',NOW()),
('Mugisha','Beata','beata.mugisha50','pass050','1993-04-07','beata.mugisha50@example.com','FEMALE',NOW()),
('Ndayambaje','Eric','eric.ndayambaje51','pass051','1980-06-10','eric.ndayambaje51@example.com','MALE',NOW()),
('Uwitonze','Sandrine','sandrine.uwitonze52','pass052','1994-05-20','sandrine.uwitonze52@example.com','FEMALE',NOW()),
('Mukazayire','Patrick','patrick.mukazayire53','pass053','1987-08-17','patrick.mukazayire53@example.com','MALE',NOW()),
('Rukundo','Beata','beata.rukundo54','pass054','1975-12-11','beata.rukundo54@example.com','FEMALE',NOW()),
('Ndizeye','Emmanuel','emmanuel.ndizeye55','pass055','1985-03-27','emmanuel.ndizeye55@example.com','MALE',NOW()),
('Ndayisaba','Clarisse','clarisse.ndayisaba56','pass056','1991-09-03','clarisse.ndayisaba56@example.com','FEMALE',NOW()),
('Munyaneza','Theoneste','theoneste.munyaneza57','pass057','1980-06-14','theoneste.munyaneza57@example.com','MALE',NOW()),
('Habyarimana','Angelique','angelique.habyarimana58','pass058','1995-01-29','angelique.habyarimana58@example.com','FEMALE',NOW()),
('Niyitegeka','Fabrice','fabrice.niyitegeka59','pass059','1988-10-03','fabrice.niyitegeka59@example.com','MALE',NOW()),
('Manirakiza','Aline','aline.manirakiza60','pass060','1992-04-25','aline.manirakiza60@example.com','FEMALE',NOW());

INSERT INTO districts (name) VALUES
                                 ('Gasabo'),
                                 ('Kicukiro'),
                                 ('Nyarugenge'),
                                 ('Kayonza'),
                                 ('Kirehe'),
                                 ('Ngoma'),
                                 ('Rwamagana'),
                                 ('Gatsibo'),
                                 ('Nyagatare'),
                                 ('Bugesera'),
                                 ('Gicumbi'),
                                 ('Musanze'),
                                 ('Burera'),
                                 ('Rulindo'),
                                 ('Gakenke'),
                                 ('Musanze'),
                                 ('Nyabihu'),
                                 ('Rubavu'),
                                 ('Rusizi'),
                                 ('Nyamasheke'),
                                 ('Karongi'),
                                 ('Rutsiro'),
                                 ('Nyamagabe'),
                                 ('Nyanza'),
                                 ('Huye'),
                                 ('Nyaruguru'),
                                 ('Ruhango'),
                                 ('Muhanga'),
                                 ('Kamonyi'),
                                 ('Muhanga');
-- Sectors for Gasabo (district_id = 1)
INSERT INTO sectors (name, district_id) VALUES
                                            ('Gatsata', 1),
                                            ('Gikomero', 1),
                                            ('Kacyiru', 1),
                                            ('Kimironko', 1),
                                            ('Ndera', 1),
                                            ('Remera', 1),
                                            ('Rusororo', 1),
                                            ('Jali', 1),
                                            ('Kanombe', 1),
                                            ('Kibagabaga', 1),

                                            -- Sectors for Kicukiro (district_id = 2)

                                            ('Gahanga', 2),
                                            ('Kagarama', 2),
                                            ('Kicukiro', 2),
                                            ('Masaka', 2),
                                            ('Nyarugunga', 2),

                                            -- Sectors for Nyarugenge (district_id = 3)

                                            ('Gitega', 3),
                                            ('Kanyinya', 3),
                                            ('Kimisagara', 3),
                                            ('Mageragere', 3),
                                            ('Muhima', 3),
                                            ('Nyakabanda', 3),
                                            ('Nyarugenge', 3),
                                            ('Rwezamenyo', 3),

                                            -- Sectors for Kayonza (district_id = 4)

                                            ('Cyarubare', 4),
                                            ('Kabare', 4),
                                            ('Murundi', 4),
                                            ('Murama', 4),
                                            ('Mwurire', 4),
                                            ('Ndego', 4),
                                            ('Nyamirama', 4),
                                            ('Rwimbogo', 4),

                                            -- Sectors for Kirehe (district_id = 5)
                                            ('Kigarama', 5),
                                            ('Kirehe', 5),
                                            ('Mahama', 5),
                                            ('Mpanga', 5),
                                            ('Muganza', 5),
                                            ('Musenyi', 5),
                                            ('Nyarubuye', 5),
                                            ('Nyankurazo', 5),

                                            -- Sectors for Ngoma (district_id = 6)
                                            ('Gashanda', 6),
                                            ('Jarama', 6),
                                            ('Karembo', 6),
                                            ('Mbuga', 6),
                                            ('Mugesera', 6),
                                            ('Nyamirama', 6),
                                            ('Nyange', 6),
                                            ('Sake', 6),

                                            -- Sectors for Rwamagana (district_id = 7)
                                            ('Fumbwe', 7),
                                            ('Gahengeri', 7),
                                            ('Gishari', 7),
                                            ('Mwurire', 7),
                                            ('Nyakariro', 7),
                                            ('Nyamirama', 7),
                                            ('Rubona', 7),
                                            ('Rwabicora', 7),

                                            -- Sectors for Gatsibo (district_id = 8)
                                            ('Gatsibo', 8),
                                            ('Kabarore', 8),
                                            ('Kageyo', 8),
                                            ('Kiziguro', 8),
                                            ('Mangar', 8),
                                            ('Muhura', 8),
                                            ('Murambi', 8),
                                            ('Nibungirwa', 8),

                                            -- Sectors for Nyagatare (district_id = 9)
                                            ('Kiyombe', 9),
                                            ('Matimba', 9),
                                            ('Katabagemu', 9),
                                            ('Rukomo', 9),
                                            ('Nyagatare', 9),
                                            ('Rwimiyaga', 9),
                                            ('Nyakarenzo', 9),
                                            ('Rukara', 9),

                                            -- Sectors for Bugesera (district_id = 10)
                                            ('Gashora', 10),
                                            ('Juru', 10),
                                            ('Mareba', 10),
                                            ('Mimuli', 10),
                                            ('Musenyi', 10),
                                            ('Ntarama', 10),
                                            ('Nyamata', 10),
                                            ('Rilima', 10),
                                            ('Ruhuha', 10),

                                            -- Sectors for Gicumbi (district_id = 11)
                                            ('Bukure', 11),
                                            ('Bwisige', 11),
                                            ('Byumba', 11),
                                            ('Coko', 11),
                                            ('Gicumbi', 11),
                                            ('Ibuga', 11),
                                            ('Kaniga', 11),
                                            ('Rukomo', 11),

                                            -- Sectors for Musanze (district_id = 12)
                                            ('Busogo', 12),
                                            ('Cyeru', 12),
                                            ('Kimonyi', 12),
                                            ('Musanze', 12),
                                            ('Muhoza', 12),
                                            ('Ruhengeri', 12),
                                            ('Sabyinyo', 12),

                                            -- Sectors for Burera (district_id = 13)
                                            ('Cyanika', 13),
                                            ('Gahunga', 13),
                                            ('Gahunga', 13),
                                            ('Kinigi', 13),
                                            ('Nyamiyaga', 13),
                                            ('Ruhunde', 13),
                                            ('Rugarama', 13),
                                            ('Ruvune', 13),

                                            -- Sectors for Rulindo (district_id = 14)
                                            ('Base', 14),
                                            ('Busasamana', 14),
                                            ('Burega', 14),
                                            ('Kigeyo', 14),
                                            ('Kinigi', 14),
                                            ('Mukarange', 14),
                                            ('Musasa', 14),
                                            ('Ntarabana', 14),

                                            -- Sectors for Gakenke (district_id = 15)
                                            ('Busengo', 15),
                                            ('Cyabingo', 15),
                                            ('Gakenke', 15),
                                            ('Janja', 15),
                                            ('Kamubuga', 15),
                                            ('Karambo', 15),
                                            ('Mugunga', 15),
                                            ('Muhondo', 15),

                                            -- Sectors for Musanze (district_id = 12)
                                            ('Busogo', 12),
                                            ('Cyeru', 12),
                                            ('Kimonyi', 12),
                                            ('Musanze', 12),
                                            ('Muhoza', 12),
                                            ('Ruhengeri', 12),
                                            ('Sabyinyo', 12),

                                            -- Sectors for Nyabihu (district_id = 16)
                                            ('Bigogwe', 16),
                                            ('Busheke', 16),
                                            ('Cyondo', 16),
                                            ('Cyuve', 16),
                                            ('Gatare', 16),
                                            ('Jomba', 16),
                                            ('Kabusiya', 16),
                                            ('Karago', 16),

                                            -- Sectors for Rubavu (district_id = 17)
                                            ('Bugeshi', 17),
                                            ('Cyanzarwe', 17),
                                            ('Gisenyi', 17),
                                            ('Kanama', 17),
                                            ('Mururu', 17),
                                            ('Nyakiriba', 17),
                                            ('Nyundo', 17),
                                            ('Rubavu', 17),

                                            -- Sectors for Rusizi (district_id = 18)
                                            ('Bugarama', 18),
                                            ('Gihundwe', 18),
                                            ('Gikundamvura', 18),
                                            ('Kabakondo', 18),
                                            ('Kamembe', 18),
                                            ('Mururu', 18),
                                            ('Nkungu', 18),
                                            ('Nkombo', 18),

                                            -- Sectors for Nyamasheke (district_id = 19)
                                            ('Bushekeri', 19),
                                            ('Gihombo', 19),
                                            ('Jenda', 19),
                                            ('Kagano', 19),
                                            ('Kanjongo', 19),
                                            ('Karambi', 19),
                                            ('Mudende', 19),
                                            ('Nyamasheke', 19),

                                            -- Sectors for Karongi (district_id = 20)
                                            ('Bwishyura', 20),
                                            ('Gitesi', 20),
                                            ('Gitesi', 20),
                                            ('Muganza', 20),
                                            ('Murambi', 20),
                                            ('Mutuntu', 20),
                                            ('Rubengera', 20),
                                            ('Ruganda', 20),

                                            -- Sectors for Rutsiro (district_id = 21)
                                            ('Gisovu', 21),
                                            ('Kivumu', 21),
                                            ('Mpundu', 21),
                                            ('Murunda', 21),
                                            ('Nyabirasi', 21),
                                            ('Nyundo', 21),
                                            ('Rutsiro', 21),

                                            -- Sectors for Nyamagabe (district_id = 22)
                                            ('Bushekeri', 22),
                                            ('Cyeza', 22),
                                            ('Kabaya', 22),
                                            ('Kamegeli', 22),
                                            ('Muganza', 22),
                                            ('Muko', 22),
                                            ('Nyamagabe', 22),
                                            ('Save', 22),

                                            -- Sectors for Nyanza (district_id = 23)
                                            ('Busasamana', 23),
                                            ('Cyarubare', 23),
                                            ('Kibirizi', 23),
                                            ('Kinazi', 23),
                                            ('Maraba', 23),
                                            ('Mbazi', 23),
                                            ('Ntyazo', 23),
                                            ('Rugendabari', 23),
                                            ('Rurembo', 23),

                                            -- Sectors for Huye (district_id = 24)
                                            ('Gishamvu', 24),
                                            ('Karama', 24),
                                            ('Kibangu', 24),
                                            ('Muganza', 24),
                                            ('Ngoma', 24),
                                            ('Ngoma', 24),
                                            ('Tumba', 24),
                                            ('Cyangugu', 24),

                                            -- Sectors for Nyaruguru (district_id = 25)
                                            ('Busanze', 25),
                                            ('Kabaya', 25),
                                            ('Kibeho', 25),
                                            ('Muganza', 25),
                                            ('Mpinga', 25),
                                            ('Nyabimata', 25),
                                            ('Ruhango', 25),
                                            ('Tare', 25),

                                            -- Sectors for Ruhango (district_id = 26)
                                            ('Bweramana', 26),
                                            ('Kinazi', 26),
                                            ('Mbuye', 26),
                                            ('Ntongwe', 26),
                                            ('Ruhango', 26),
                                            ('Mwendo', 26),

                                            -- Sectors for Muhanga (district_id = 27)

                                            ('Gitarama', 27),
                                            ('Kigabiro', 27),
                                            ('Kiyumba', 27),
                                            ('Mbuye', 27),
                                            ('Muhanga', 27),
                                            ('Nyaruguru', 27),
                                            ('Rukoma', 27),
                                            ('Shyogwe', 27),

                                            -- Sectors for Kamonyi (district_id = 28)
                                            ('Gacurabwenge', 28),
                                            ('Kamabuye', 28),
                                            ('Karambo', 28),
                                            ('Kamonyi', 28),
                                            ('Muhanga', 28),
                                            ('Rugendabari', 28),
                                            ('Runda', 28);


/* ------------------------------------------------------------------
   Seed data for VerificationType
   ------------------------------------------------------------------
   If you already have rows with these labels, add:
       ON CONFLICT (label) DO NOTHING
   after each VALUES (…) or at the end of the whole INSERT.
------------------------------------------------------------------- */

-- Use the correct table name for your schema ↓
INSERT INTO verification_type (label) VALUES
                                          ('IN_PERSON_SCHOOL_ADMIN'),
                                          ('MOBILE_MONEY_NAME_MATCH'),
                                          ('UPLOADED_DOCUMENTS_REVIEW'),
                                          ('VIDEO_CALL'),
                                          ('EMBASSY_ATTESTATION'),
                                          ('TRUSTED_SYSTEM_IMPORT'),
                                          ('EMAIL_CONFIRMATION'),
                                          ('PHONE_CONFIRMATION'),
                                          ('DELEGATED_BY_VERIFIED_USER');

INSERT INTO degree_types (name, description) VALUES
                                                 ('NURSERY', 'Nursery Certificate / Early childhood education'),
                                                 ('PRIMARY', 'Primary Certificate / Primary school education'),
                                                 ('O_LEVEL', 'Ordinary Level secondary education (Lower secondary)'),
                                                 ('A_LEVEL', 'Advanced Level secondary education (Upper secondary)'),
                                                 ('TVET', 'Technical and Vocational Education and Training'),
                                                 ('UNIVERSITY', 'University-level education (Bachelor, Masters, PhD)'),
                                                 ('ADULT_EDU', 'Adult education and literacy programs'),
                                                 ('TEACHER_TRAINING', 'Teacher training colleges and programs');

INSERT INTO education_levels (degree_type_id, description, level_order) VALUES
                                                                            ((SELECT id FROM degree_types WHERE name = 'NURSERY'), 'Pre-primary early childhood education', -1),
                                                                            ((SELECT id FROM degree_types WHERE name = 'PRIMARY'), 'Primary school education (P1–P6)', 1),
                                                                            ((SELECT id FROM degree_types WHERE name = 'O_LEVEL'), 'Lower secondary education (S1–S3)', 2),
                                                                            ((SELECT id FROM degree_types WHERE name = 'A_LEVEL'), 'Upper secondary education (S4–S6), including science and literature streams', 3),
                                                                            ((SELECT id FROM degree_types WHERE name = 'TVET'), 'Technical and Vocational Education and Training (Levels 3–5)', 4),
                                                                            ((SELECT id FROM degree_types WHERE name = 'UNIVERSITY'), 'Higher education, including Bachelor, Masters, and PhD degrees', 5),
                                                                            ((SELECT id FROM degree_types WHERE name = 'ADULT_EDU'), 'Special adult learning programs (alphabetization, etc.)', 6),
                                                                            ((SELECT id FROM degree_types WHERE name = 'TEACHER_TRAINING'), 'Teacher training colleges (TTCs)', 3);


-- Sections for A_LEVEL
INSERT INTO sections (id, name, education_level_id) VALUES
                                                        (1, 'Science', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'A_LEVEL')),
                                                        (2, 'Arts', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'A_LEVEL')),
                                                        (3, 'Commerce', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'A_LEVEL')),
                                                        (4, 'Literature', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'A_LEVEL')),
                                                        (5, 'Computer Science', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'A_LEVEL')),
                                                        (6, 'Mathematics', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'A_LEVEL')),
                                                        (7, 'Languages', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'A_LEVEL'));

-- Sections for TVET
INSERT INTO sections (id, name, education_level_id) VALUES
                                                        (8, 'Electrical Engineering', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'TVET')),
                                                        (9, 'Construction Technology', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'TVET')),
                                                        (10, 'Automotive Mechanics', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'TVET')),
                                                        (11, 'Carpentry and Joinery', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'TVET')),
                                                        (12, 'Catering and Hotel Management', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'TVET')),
                                                        (13, 'Agriculture', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'TVET')),
                                                        (14, 'Welding and Fabrication', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'TVET')),
                                                        (15, 'Plumbing', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'TVET')),
                                                        (16, 'Information Technology', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'TVET'));

-- Sections for UNIVERSITY
INSERT INTO sections (id, name, education_level_id) VALUES
                                                        (17, 'Faculty of Science', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'UNIVERSITY')),
                                                        (18, 'Faculty of Arts', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'UNIVERSITY')),
                                                        (19, 'Faculty of Law', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'UNIVERSITY')),
                                                        (20, 'Faculty of Engineering', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'UNIVERSITY')),
                                                        (21, 'Faculty of Business', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'UNIVERSITY')),
                                                        (22, 'Faculty of Education', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'UNIVERSITY')),
                                                        (23, 'Faculty of Medicine', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'UNIVERSITY'));

-- Sections for PRIMARY
INSERT INTO sections (id, name, education_level_id) VALUES
                                                        (24, 'Grade 1', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'PRIMARY')),
                                                        (25, 'Grade 2', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'PRIMARY')),
                                                        (26, 'Grade 3', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'PRIMARY')),
                                                        (27, 'Grade 4', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'PRIMARY')),
                                                        (28, 'Grade 5', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'PRIMARY')),
                                                        (29, 'Grade 6', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'PRIMARY'));

-- Sections for NURSERY
INSERT INTO sections (id, name, education_level_id) VALUES
                                                        (30, 'Nursery 1', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'NURSERY')),
                                                        (31, 'Nursery 2', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'NURSERY')),
                                                        (32, 'Pre-primary', (SELECT e.id FROM education_levels e JOIN degree_types d ON e.degree_type_id = d.id WHERE d.name = 'NURSERY'));



INSERT INTO schools (id, name, abbrev_name, logo_url, has_boarding, contact_phone, contact_email, website_url, district_id, sector_id) VALUES
                                                                                                                                           (1, 'Kigali High School', 'KHS', NULL, TRUE, '+250788123456', 'info@khs.rw', 'https://khs.rw', 1, 1),
                                                                                                                                           (2, 'Integrated Polytechnic Regional College Kigali', 'IPRC K', NULL, FALSE, '+250788654321', 'contact@iprc.rw', 'https://iprc.rw', 1, 2),
                                                                                                                                           (3, 'University of Rwanda', 'UR', NULL, TRUE, '+250788112233', 'info@ur.ac.rw', 'https://ur.ac.rw', 1, 3),
                                                                                                                                           (4, 'Nyundo Secondary School', 'NSS', NULL, FALSE, '+250788998877', 'admin@nyundo.rw', 'https://nyundo.rw', 2, 4),
                                                                                                                                           (5, 'GS Nyagatare', 'GSN', NULL, FALSE, '+250788776655', 'contact@gsnyagatare.rw', 'https://gsnyagatare.rw', 3, 5),
                                                                                                                                           (6, 'Ecole Belge de Kigali', 'EBK', NULL, FALSE, '+250788445566', 'info@ebk.rw', 'https://ebk.rw', 1, 1),
                                                                                                                                           (7, 'Green Hills Academy', 'GHA', NULL, TRUE, '+250788998800', 'info@gha.rw', 'https://gha.rw', 1, 1),
                                                                                                                                           (8, 'College Saint Andre', 'CSA', NULL, TRUE, '+250788774455', 'contact@csa.rw', 'https://csa.rw', 2, 6),
                                                                                                                                           (9, 'Ecole Primaire de Kigali', 'EPK', NULL, FALSE, '+250788553344', 'contact@epk.rw', 'https://epk.rw', 1, 7),
                                                                                                                                           (10, 'UMUTARA Polytechnic', 'UP', NULL, FALSE, '+250788998811', 'contact@umutara.rw', 'https://umutara.rw', 4, 8),
                                                                                                                                           (11, 'Ecole Primaire Rwesero', 'EPR', NULL, FALSE, '+250788665544', 'contact@rwesero.rw', 'https://rwesero.rw', 5, 9),
                                                                                                                                           (12, 'GS Kiyovu', 'GSK', NULL, FALSE, '+250788332211', 'contact@gsk.rw', 'https://gsk.rw', 1, 10),
                                                                                                                                           (13, 'EPAG', 'EPAG', NULL, FALSE, '+250788778899', 'contact@epag.rw', 'https://epag.rw', 6, 11),
                                                                                                                                           (14, 'School of Finance and Banking', 'SFB', NULL, FALSE, '+250788223344', 'contact@sfb.rw', 'https://sfb.rw', 1, 1),
                                                                                                                                           (15, 'Groupe Scolaire Officiel de Butare', 'GSOB', NULL, TRUE, '+250788556677', 'contact@gsob.rw', 'https://gsob.rw', 7, 12),
                                                                                                                                           (16, 'GS Rwamagana', 'GSR', NULL, FALSE, '+250788889900', 'contact@gsrw.rw', 'https://gsrw.rw', 8, 13),
                                                                                                                                           (17, 'GS Kirehe', 'GSKI', NULL, FALSE, '+250788111222', 'contact@gskirehe.rw', 'https://gskirehe.rw', 9, 14),
                                                                                                                                           (18, 'GS Nyundo', 'GSN', NULL, TRUE, '+250788333444', 'contact@gsnyundo.rw', 'https://gsnyundo.rw', 2, 15),
                                                                                                                                           (19, 'University of Kibungo', 'UNIK', NULL, TRUE, '+250788444555', 'info@unik.rw', 'https://unik.rw', 10, 16),
                                                                                                                                           (20, 'GS Nyagatare', 'GSNY', NULL, FALSE, '+250788555666', 'contact@gsnyagatare.rw', 'https://gsnyagatare.rw', 3, 17),
                                                                                                                                           (21, 'College du Christ Roi Nyanza', 'CXR', NULL, TRUE, '+250788111333', 'info@cxr.rw', 'https://cxr.rw', 11, 18),
                                                                                                                                           (22, 'GS Officiel de Butare', 'GSOB', NULL, TRUE, '+250788222444', 'contact@gsob.rw', 'https://gsob.rw', 11, 18),
                                                                                                                                           (23, 'Petit Seminaire Virgo Fidelis', 'PSVF', NULL, FALSE, '+250788333555', 'info@psvf.rw', 'https://psvf.rw', 11, 19),
                                                                                                                                           (24, 'Mater Dei Nyanza', 'MDN', NULL, TRUE, '+250788444666', 'contact@materdei.rw', 'https://materdei.rw', 11, 20),
                                                                                                                                           (25, 'Ecole Primaire Nyanza', 'EPN', NULL, FALSE, '+250788555777', 'contact@epnyanza.rw', 'https://epnyanza.rw', 11, 21),
                                                                                                                                           (26, 'Nyanza Technical School', 'NTS', NULL, FALSE, '+250788666888', 'contact@nts.rw', 'https://nts.rw', 11, 22),
                                                                                                                                           (27, 'GS Nyanza Commercial', 'GSNC', NULL, FALSE, '+250788777999', 'info@gsnc.rw', 'https://gsnc.rw', 11, 23),
                                                                                                                                           (28, 'Ecole de Science Saint Louis de Montfort Nyanza', 'ESN', NULL, FALSE, '+250788888000', 'info@esn.rw', 'https://esn.rw', 11, 24);
-- Science combinations
INSERT INTO combinations (id, code, description, section_id) VALUES
                                                                 (1, 'MCB', 'Maths - Chemistry - Biology',         1),
                                                                 (2, 'MPC', 'Maths - Physics - Chemistry',         1),
                                                                 (3, 'PCB', 'Physics - Chemistry - Biology',       1),
                                                                 (4, 'PCM', 'Physics - Chemistry - Maths',         1),
                                                                 (5, 'BCG', 'Biology - Chemistry - Geography',     1),
                                                                 (6, 'MPG', 'Maths - Physics - Geography',         1),
                                                                 (7, 'MPCs', 'Maths - Physics - Computer Science', 1),
                                                                 (8, 'MCG', 'Maths - Chemistry - Geography',       1),

-- Arts combinations
                                                                 (9, 'HEG', 'History - Economics - Geography',     2),
                                                                 (10, 'MEG', 'Maths - Economics - Geography',      2),
                                                                 (11, 'LEG', 'Literature - Economics - Geography', 2),
                                                                 (12, 'EKK', 'Entrepreneurship - Kinyarwanda - Kiswahili', 2),
                                                                 (13, 'HKL', 'History - Kinyarwanda - Literature', 2),
                                                                 (14, 'HEL', 'History - Economics - Literature',   2),
                                                                 (15, 'HGP', 'History - Geography - Political Ed.',2),

-- TVET / technical-scientific
                                                                 (16, 'ITN', 'Information Technology - Networking - Systems', 3),
                                                                 (17, 'ELE', 'Electronics - Electricity - Automation',        3),
                                                                 (18, 'MEC', 'Mechanics - Engineering Drawing - Auto',        3);

-- Insert common courses
INSERT INTO courses (name, description) VALUES
                                            ('Mathematics', 'General mathematics course including arithmetic, algebra, and geometry'),
                                            ('English', 'English language, grammar, and literature studies'),
                                            ('Kinyarwanda', 'Kinyarwanda language and culture'),
                                            ('French', 'French language basics and literature'),
                                            ('Physics', 'Fundamentals of physics including mechanics and energy'),
                                            ('Chemistry', 'Introductory chemistry and lab work'),
                                            ('Biology', 'Human and plant biology with lab practice'),
                                            ('Geography', 'Geography of Rwanda, Africa, and the world'),
                                            ('History', 'History of Rwanda, Africa, and the world'),
                                            ('Economics', 'Basic economic principles and micro/macro economics'),
                                            ('Entrepreneurship', 'Entrepreneurship education and small business principles'),
                                            ('Computer Science', 'Basic computing, coding, and digital literacy'),
                                            ('Religion', 'Religious studies including Christianity and ethics'),
                                            ('Music', 'Music theory, choir, and instrument training'),
                                            ('Physical Education', 'Sports, physical activities, and health awareness'),
                                            ('Social Studies', 'Basic civics and social responsibility'),
                                            ('Swahili', 'Basic Kiswahili for communication in East Africa'),

-- A-Level specialized
                                            ('Advanced Mathematics', 'Pure and applied math for A-Level'),
                                            ('Physics (A-Level)', 'Advanced physics curriculum'),
                                            ('Chemistry (A-Level)', 'Advanced chemistry curriculum'),
                                            ('Biology (A-Level)', 'Advanced biology for science sections'),
                                            ('Literature in English', 'Literary analysis and essay writing'),
                                            ('Geography (A-Level)', 'Physical and human geography'),
                                            ('History (A-Level)', 'World history and Rwandan independence'),
                                            ('Economics (A-Level)', 'Economic theory, statistics, and trade'),
                                            ('Computer Programming', 'Software development and problem-solving'),
                                            ('Principles of Accounting', 'Financial accounting and bookkeeping'),
                                            ('Commerce', 'Principles of trade, business, and marketing'),
                                            ('Political Education', 'Governance, law, and rights education'),

-- TVET & Vocational

                                            ('Electrical Engineering', 'Practical and theoretical skills in electricity'),
                                            ('Welding and Fabrication', 'Welding techniques and workshop safety'),
                                            ('Automobile Mechanics', 'Car mechanics and maintenance'),
                                            ('Masonry', 'Construction and brickwork skills'),
                                            ('Fashion and Design', 'Garment construction and textile design'),
                                            ('Plumbing', 'Pipe fitting and sanitation systems'),
                                            ('Carpentry', 'Woodwork and furniture design'),
                                            ('Hospitality Management', 'Hotel, tourism, and customer service'),
                                            ('Information Technology', 'IT systems, software, and networking'),
                                            ('Agriculture', 'Crop and animal farming methods'),

-- University-level examples

                                            ('Calculus I', 'Introduction to limits, derivatives, and integrals'),
                                            ('Computer Networks', 'Network protocols and architectures'),
                                            ('Software Engineering', 'Development methodologies and SDLC'),
                                            ('Introduction to Law', 'Rwandan legal systems and case law'),
                                            ('Public Health', 'Community health and epidemiology'),
                                            ('Data Structures', 'Efficient storage and access of data'),
                                            ('Clinical Medicine', 'Introduction to diagnostics and treatment'),
                                            ('Environmental Science', 'Ecology, sustainability, and natural resource management');

INSERT INTO combination_courses (combination_id, course_id) VALUES
-- MCB: Maths, Chemistry, Biology
(1, 1), (1, 2), (1, 3),  -- MCB

-- MPC: Maths, Physics, Chemistry
(2, 1), (2, 4), (2, 2),

-- PCB: Physics, Chemistry, Biology
(3, 4), (3, 2), (3, 3),

-- PCM: Physics, Chemistry, Maths
(4, 4), (4, 2), (4, 1),

-- BCG: Biology, Chemistry, Geography
(5, 3), (5, 2), (5, 5),

-- MPG: Maths, Physics, Geography

(6, 1), (6, 4), (6, 5),

-- MPCs: Maths, Physics, Computer Science
(7, 1), (7, 4), (7, 6),

-- MCG: Maths, Chemistry, Geography
(8, 1), (8, 2), (8, 5),

-- HEG: History, Economics, Geography
(9, 7), (9, 8), (9, 5),

-- MEG: Maths, Economics, Geography
(10, 1), (10, 8), (10, 5),

-- LEG: Literature, Economics, Geography
(11, 9), (11, 8), (11, 5),

-- EKK: Entrepreneurship, Kinyarwanda, Kiswahili
(12, 10), (12, 11), (12, 12),

-- HKL: History, Kinyarwanda, Literature
(13, 7), (13, 11), (13, 9),

-- HEL: History, Economics, Literature
(14, 7), (14, 8), (14, 9),

-- HGP: History, Geography, Political Education
(15, 7), (15, 5), (15, 13),

-- ITN: IT, Networking, Systems
(16, 6), (16, 14), (16, 15),

-- ELE: Electronics, Electricity, Automation
(17, 16), (17, 17), (17, 18),

-- MEC: Mechanics, Drawing, Auto
(18, 19), (18, 20), (18, 21);

/* ──────────────────────────────────────────
   Academic years
   (assumes id is auto‑generated)
────────────────────────────────────────── */
INSERT INTO academic_years (start_date, end_date) VALUES
                                                      ('2020-09-01', '2021-07-31'),
                                                      ('2021-09-01', '2022-07-31'),
                                                      ('2022-09-01', '2023-07-31'),
                                                      ('2023-09-01', '2024-07-31'),
                                                      ('2024-09-01', '2025-07-31');   -- current year

/* ──────────────────────────────────────────
   Bank accounts
   bank_id mapping (if you followed earlier seed):
     1 = Bank of Kigali
     2 = Equity Bank
     3 = I&M Bank
────────────────────────────────────────── */
INSERT INTO bank_accounts (account_owner_id, bank_id, account_number) VALUES
                                                                          -- Kigali High School  (school_id 1)
                                                                          (1, 1, 'BK-001-000123456'),
                                                                          (1, 3, 'IM-001-000987654'),

                                                                          -- IPRC Kigali  (school_id 2)
                                                                          (2, 2, 'EQ-002-345678901'),

                                                                          -- University of Rwanda  (school_id 3)
                                                                          (3, 1, 'BK-003-111222333'),
                                                                          (3, 3, 'IM-003-444555666'),

                                                                          -- Nyundo Secondary School  (school_id 4)
                                                                          (4, 2, 'EQ-004-777888999'),

                                                                          -- GS Nyagatare  (school_id 5)
                                                                          (5, 1, 'BK-005-112233445'),

                                                                          -- College du Christ Roi (CXR)  (school_id 21)
                                                                          (21, 1, 'BK-021-556677889'),

                                                                          -- Petit Seminaire Virgo Fidelis (PSVF) (school_id 23)
                                                                          (23, 2, 'EQ-023-667788990'),

                                                                          -- Mater Dei Nyanza  (school_id 24)
                                                                          (24, 1, 'BK-024-778899001'),
                                                                          (24, 3, 'IM-024-002113344'),

                                                                          -- Ecole Sci. St‑Louis de Montfort Nyanza (ESN) (school_id 28)
                                                                          (28, 1, 'BK-028-909008007');




INSERT INTO users_roles (user_id, role_id) VALUES
                                               (1, 4),
                                               (2, 4),
                                               (3, 4),
                                               (4, 4),
                                               (5, 4),
                                               (6, 4),
                                               (7, 4),
                                               (8, 4),
                                               (9, 4),
                                               (10, 4),
                                               (10, 3),
                                               (11, 4),
                                               (12, 4),
                                               (13, 4),
                                               (14, 4),
                                               (15, 4),
                                               (15, 2),
                                               (16, 4),
                                               (17, 4),
                                               (18, 4),
                                               (19, 4),
                                               (20, 4),
                                               (20, 3),
                                               (21, 4),
                                               (22, 4),
                                               (23, 4),
                                               (24, 4),
                                               (25, 4),
                                               (25, 2),
                                               (26, 4),
                                               (27, 4),
                                               (28, 4),
                                               (29, 4),
                                               (30, 4),
                                               (30, 3),
                                               (31, 4),
                                               (32, 4),
                                               (33, 4),
                                               (34, 4),
                                               (35, 4),
                                               (35, 2),
                                               (36, 4),
                                               (37, 4),
                                               (38, 4),
                                               (39, 4),
                                               (40, 4),
                                               (40, 3),
                                               (41, 4),
                                               (42, 4),
                                               (43, 4),
                                               (44, 4),
                                               (45, 4),
                                               (45, 2),
                                               (46, 4),
                                               (47, 4),
                                               (48, 4),
                                               (49, 4),
                                               (50, 4),
                                               (50, 3),
                                               (51, 4),
                                               (52, 4),
                                               (53, 4),
                                               (54, 4),
                                               (55, 4),
                                               (55, 2),
                                               (56, 4),
                                               (57, 4),
                                               (58, 4),
                                               (59, 4),
                                               (60, 4),
                                               (60, 3),
                                               (1, 1);  -- Administrator role


/*  School‑Level offerings for academic years 2020‑2025
    ---------------------------------------------------------------------------
    (school_id, education_level_id, academic_year_id)
    ---------------------------------------------------------------------------
*/
INSERT INTO school_level_offerings (school_id, education_level_id, academic_year_id) VALUES
-- Kigali High School (O‑ & A‑Level)
(1, 1, 1),(1, 1, 2),(1, 1, 3),(1, 1, 4),(1, 1, 5),
(1, 2, 1),(1, 2, 2),(1, 2, 3),(1, 2, 4),(1, 2, 5),

-- IPRC Kigali (TVET)
(2, 3, 1),(2, 3, 2),(2, 3, 3),(2, 3, 4),(2, 3, 5),

-- University of Rwanda (University & A‑Level bridging)
(3, 4, 1),(3, 4, 2),(3, 4, 3),(3, 4, 4),(3, 4, 5),
(3, 2, 1),(3, 2, 2),(3, 2, 3),(3, 2, 4),(3, 2, 5),

-- Nyundo Secondary (O‑ & A‑Level)
(4, 1, 1),(4, 1, 2),(4, 1, 3),(4, 1, 4),(4, 1, 5),
(4, 2, 1),(4, 2, 2),(4, 2, 3),(4, 2, 4),(4, 2, 5),

-- GS Nyagatare (O‑Level)
(5, 1, 1),(5, 1, 2),(5, 1, 3),(5, 1, 4),(5, 1, 5),

-- Ecole Belge de Kigali (Primary)
(6, 5, 1),(6, 5, 2),(6, 5, 3),(6, 5, 4),(6, 5, 5),

-- Green Hills Academy (A‑Level + Primary)
(7, 2, 1),(7, 2, 2),(7, 2, 3),(7, 2, 4),(7, 2, 5),
(7, 5, 1),(7, 5, 2),(7, 5, 3),(7, 5, 4),(7, 5, 5),

-- Coll. St‑Andre (O‑ & A‑Level)
(8, 1, 1),(8, 1, 2),(8, 1, 3),(8, 1, 4),(8, 1, 5),
(8, 2, 1),(8, 2, 2),(8, 2, 3),(8, 2, 4),(8, 2, 5),

-- Ecole Primaire de Kigali (Primary)
(9, 5, 1),(9, 5, 2),(9, 5, 3),(9, 5, 4),(9, 5, 5),

-- UMUTARA Polytechnic (TVET)
(10, 3, 1),(10, 3, 2),(10, 3, 3),(10, 3, 4),(10, 3, 5),

-- … (similar pattern for remaining schools up to id 28) …
-- College du Christ Roi Nyanza (CXR) ‑ offers O‑ & A‑Level
(21, 1, 1),(21, 1, 2),(21, 1, 3),(21, 1, 4),(21, 1, 5),
(21, 2, 1),(21, 2, 2),(21, 2, 3),(21, 2, 4),(21, 2, 5),

-- Petit Séminaire Virgo Fidelis (PSVF) – TVET
(23, 3, 1),(23, 3, 2),(23, 3, 3),(23, 3, 4),(23, 3, 5),

-- Mater Dei Nyanza – University + A‑Level
(24, 4, 1),(24, 4, 2),(24, 4, 3),(24, 4, 4),(24, 4, 5),
(24, 2, 1),(24, 2, 2),(24, 2, 3),(24, 2, 4),(24, 2, 5),

-- ESN (St‑Louis de Montfort) – TVET
(28, 3, 1),(28, 3, 2),(28, 3, 3),(28, 3, 4),(28, 3, 5);
INSERT INTO user_verification (verification_type_id, verified_user_id, verifying_in_charge_user_id, date)
VALUES
    (1, 2, 1, now()),
    (3, 3, 2, now()),
    (5, 4, 2, now()),
    (7, 5, 3, now()),
    (2, 6, 4, now()),
    (1, 7, 1, now()),
    (9, 8, 5, now()),
    (6, 9, 3, now()),
    (4, 10, 2, now()),
    (1, 11, 6, now()),
    (2, 12, 3, now()),
    (3, 13, 7, now()),
    (8, 14, 1, now()),
    (7, 15, 2, now()),
    (5, 16, 2, now()),
    (1, 17, 8, now()),
    (3, 18, 4, now()),
    (9, 19, 5, now()),
    (1, 20, 6, now()),
    (2, 21, 7, now()),
    (6, 22, 1, now()),
    (3, 23, 2, now()),
    (5, 24, 2, now()),
    (8, 25, 3, now()),
    (7, 26, 1, now()),
    (1, 27, 6, now()),
    (2, 28, 4, now()),
    (9, 29, 3, now()),
    (6, 30, 5, now()),
    (1, 31, 1, now()),
    (2, 32, 2, now()),
    (4, 33, 7, now()),
    (3, 34, 6, now()),
    (8, 35, 8, now()),
    (5, 36, 3, now()),
    (1, 37, 1, now()),
    (3, 38, 4, now()),
    (7, 39, 5, now()),
    (6, 40, 2, now()),
    (1, 41, 6, now()),
    (2, 42, 7, now()),
    (5, 43, 1, now()),
    (4, 44, 8, now()),
    (3, 45, 3, now()),
    (1, 46, 5, now()),
    (2, 47, 6, now()),
    (9, 48, 4, now()),
    (7, 49, 2, now()),
    (8, 50, 1, now());

-- Nursery level (ID = 6)
INSERT INTO education_level_courses (education_level_id, course_id) VALUES
                                                                        (6, 3),   -- Kinyarwanda
                                                                        (6, 2),   -- English
                                                                        (6, 14),  -- Music
                                                                        (6, 15);  -- Physical Education

-- Primary level (ID = 5)
INSERT INTO education_level_courses (education_level_id, course_id) VALUES
                                                                        (5, 1),   -- Mathematics
                                                                        (5, 2),   -- English
                                                                        (5, 3),   -- Kinyarwanda
                                                                        (5, 4),   -- French
                                                                        (5, 13),  -- Religion
                                                                        (5, 14),  -- Music
                                                                        (5, 15),  -- PE
                                                                        (5, 16);  -- Social Studies

-- O Level (ID = 1)
INSERT INTO education_level_courses (education_level_id, course_id) VALUES
                                                                        (1, 1),   -- Mathematics
                                                                        (1, 2),   -- English
                                                                        (1, 3),   -- Kinyarwanda
                                                                        (1, 4),   -- French
                                                                        (1, 5),   -- Physics
                                                                        (1, 6),   -- Chemistry
                                                                        (1, 7),   -- Biology
                                                                        (1, 8),   -- Geography
                                                                        (1, 9),   -- History
                                                                        (1, 10),  -- Economics
                                                                        (1, 11),  -- Entrepreneurship
                                                                        (1, 13),  -- Religion
                                                                        (1, 15),  -- PE
                                                                        (1, 17);  -- Swahili

-- A Level (ID = 2)
INSERT INTO education_level_courses (education_level_id, course_id) VALUES
                                                                        (2, 18),  -- Advanced Math
                                                                        (2, 19),  -- Physics A-Level
                                                                        (2, 20),  -- Chemistry A-Level
                                                                        (2, 21),  -- Biology A-Level
                                                                        (2, 22),  -- Literature in English
                                                                        (2, 23),  -- Geography A-Level
                                                                        (2, 24),  -- History A-Level
                                                                        (2, 25),  -- Economics A-Level
                                                                        (2, 26),  -- Programming
                                                                        (2, 27),  -- Accounting
                                                                        (2, 28),  -- Commerce
                                                                        (2, 29);  -- Political Education

-- TVET (ID = 3)
INSERT INTO education_level_courses (education_level_id, course_id) VALUES
                                                                        (3, 30), (3, 31), (3, 32), (3, 33), (3, 34), (3, 35), (3, 36), (3, 37), (3, 38), (3, 39);

-- University (ID = 4)
INSERT INTO education_level_courses (education_level_id, course_id) VALUES
                                                                        (4, 40), (4, 41), (4, 42), (4, 43), (4, 44), (4, 45), (4, 46), (4, 47);


-- School IDs are assumed from earlier inserts
-- Education Level IDs:
-- 1: NURSERY, 2: PRIMARY, 3: O_LEVEL, 4: A_LEVEL, 5: TVET, 6: UNIVERSITY

-- College du Christ Roi (CXR) - O_LEVEL and A_LEVEL
INSERT INTO schools_education_levels (school_id, education_level_id) VALUES
                                                                         (21, 3), -- O_LEVEL
                                                                         (21, 4); -- A_LEVEL

-- GSOB - O_LEVEL and A_LEVEL
INSERT INTO schools_education_levels (school_id, education_level_id) VALUES
                                                                         (22, 3),
                                                                         (22, 4);

-- PSVF - TVET or O_LEVEL depending on actual offering
INSERT INTO schools_education_levels (school_id, education_level_id) VALUES
    (23, 5);

-- Mater Dei Nyanza - A_LEVEL and UNIVERSITY
INSERT INTO schools_education_levels (school_id, education_level_id) VALUES
                                                                         (24, 4),
                                                                         (24, 6);

-- ESN - likely TVET
INSERT INTO schools_education_levels (school_id, education_level_id) VALUES
    (28, 5);

-- Green Hills Academy (sample) - all levels
INSERT INTO schools_education_levels (school_id, education_level_id) VALUES
                                                                         (7, 1),
                                                                         (7, 2),
                                                                         (7, 3),
                                                                         (7, 4),
                                                                         (7, 5),
                                                                         (7, 6);

-- Add more general schools
INSERT INTO schools_education_levels (school_id, education_level_id) VALUES
                                                                         (5, 3),  -- GS Nyagatare - O_LEVEL
                                                                         (6, 2),  -- Ecole Belge de Kigali - PRIMARY
                                                                         (10, 5), -- TVET School
                                                                         (13, 5), -- Another TVET
                                                                         (14, 6), -- University
                                                                         (19, 6); -- Public university

