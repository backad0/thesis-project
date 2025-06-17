-- Создание таблицы PersonInfo
CREATE TABLE IF NOT EXISTS application_storage.person_info (
    id UUID PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    birth_date DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы PassportInfo
CREATE TABLE IF NOT EXISTS application_storage.passport_info (
    id UUID PRIMARY KEY,
    person_id UUID NOT NULL,
    passport_number VARCHAR(20) NOT NULL UNIQUE,
    issue_date DATE NOT NULL,
    issue_place VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES application_storage.person_info(id)
);

-- Создание таблицы LoanInfo
CREATE TABLE IF NOT EXISTS application_storage.loan_info (
    id UUID PRIMARY KEY,
    amount DECIMAL(15, 2) NOT NULL,
    term INT NOT NULL,
    interest_rate DECIMAL(5, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы Offer
CREATE TABLE IF NOT EXISTS application_storage.offer (
    id UUID PRIMARY KEY,
    loan_info_id UUID NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_loan_info FOREIGN KEY (loan_info_id) REFERENCES application_storage.loan_info(id)
);

-- Создание таблицы ApplicationStatus
CREATE TABLE IF NOT EXISTS application_storage.application_status (
    id UUID PRIMARY KEY,
    status_name VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы FinalDecision
CREATE TABLE IF NOT EXISTS application_storage.final_decision (
    id UUID PRIMARY KEY,
    decision VARCHAR(50) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы Application
CREATE TABLE IF NOT EXISTS application_storage.application (
    id UUID PRIMARY KEY,
    person_info_id UUID NOT NULL,
    passport_info_id UUID NOT NULL,
    loan_info_id UUID NOT NULL,
    offer_id UUID,
    application_status_id UUID NOT NULL,
    final_decision_id UUID,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_person_info FOREIGN KEY (person_info_id) REFERENCES application_storage.person_info(id),
    CONSTRAINT fk_passport_info FOREIGN KEY (passport_info_id) REFERENCES application_storage.passport_info(id),
    CONSTRAINT fk_loan_info FOREIGN KEY (loan_info_id) REFERENCES application_storage.loan_info(id),
    CONSTRAINT fk_offer FOREIGN KEY (offer_id) REFERENCES application_storage.offer(id),
    CONSTRAINT fk_application_status FOREIGN KEY (application_status_id) REFERENCES application_storage.application_status(id),
    CONSTRAINT fk_final_decision FOREIGN KEY (final_decision_id) REFERENCES application_storage.final_decision(id)
);
