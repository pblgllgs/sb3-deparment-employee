start:
	@echo Starting MySQL database
	docker compose up -d

stop:
	@echo Stoping MySQL database
	docker compose down

delete:
	@echo Stoping MySQL database
	docker compose down -v