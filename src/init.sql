CREATE TABLE medicos (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL,
                         telefone VARCHAR(15),
                         crm VARCHAR(50) NOT NULL,
                         especialidade VARCHAR(50) NOT NULL,
                         endereco VARCHAR(255),
                         ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE pacientes (
                           id BIGSERIAL PRIMARY KEY,
                           nome VARCHAR(100) NOT NULL,
                           email VARCHAR(100) UNIQUE NOT NULL,
                           telefone VARCHAR(15),
                           cpf VARCHAR(11) NOT NULL,
                           endereco VARCHAR(255),
                           ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE consultas (
                           id BIGSERIAL PRIMARY KEY,
                           medico_id BIGINT REFERENCES medicos(id),
                           paciente_id BIGINT REFERENCES pacientes(id),
                           data_hora TIMESTAMP NOT NULL,
                           cancelada BOOLEAN DEFAULT FALSE,
                           motivo_cancelamento VARCHAR(255)
);

INSERT INTO medicos (nome, email, telefone, crm, especialidade, endereco, ativo) VALUES
                                                                                     ('Ivan Drago', 'ivan.drago@ussr.com', '+1 123456789', '1234567', 'Cardiologia', 'Rua Principal, 123', true),
                                                                                     ('Svetlana Petrova', 'svetlana.petrova@ussr.com', '+1 987654321', '7654321', 'Ginecologia', 'Avenida Central, 456', true),
                                                                                     ('Dmitri Ivanov', 'dmitri.ivanov@ussr.com', '+1 555555555', '9876543', 'Ortopedia', 'Praça Central, 789', true),
                                                                                     ('Olga Romanova', 'olga.romanova@ussr.com', '+1 111111111', '8765432', 'Dermatologia', 'Rua Principal, 321', true);

INSERT INTO pacientes (nome, email, telefone, cpf, endereco, ativo) VALUES
                                                                        ('Natalia Sokolova', 'natalia.sokolova@ussr.com', '+1 999999999', '12345678901', 'Rua Principal, 987', true),
                                                                        ('Igor Popov', 'igor.popov@ussr.com', '+1 777777777', '98765432101', 'Avenida Central, 654', true),
                                                                        ('Ekaterina Ivanova', 'ekaterina.ivanova@ussr.com', '+1 222222222', '12345678902', 'Praça Central, 321', true),
                                                                        ('Viktor Smirnov', 'viktor.smirnov@ussr.com', '+1 333333333', '98765432102', 'Rua Principal, 789', true);

INSERT INTO consultas (medico_id, paciente_id, data_hora, cancelada, motivo_cancelamento) VALUES
                                                                                              (1, 1, '2023-06-05 10:00:00', false, NULL),
                                                                                              (2, 3, '2023-06-06 14:30:00', false, NULL),
                                                                                              (3, 2, '2023-06-07 09:45:00', false, NULL),
                                                                                              (4, 4, '2023-06-08 16:15:00', false, NULL);
