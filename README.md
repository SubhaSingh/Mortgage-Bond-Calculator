# bond_calculator_app

Fixed Mortgage Bond Calculator Web App

## Requirements

* Linux (Developed with Linux Mint 18 Cinnamon 64-bit)
* Oracle Java 8
* Leiningen (v2.7 or later)
* Datomic Free v0.9.5656 or later

## Usage

Ensure Datomic Free transactor is running
Datomic:

	$ 	cd path-to-datomic-free
		bin/transactor config/samples/free-transactor-template.properties

Start a REPL:

	$ 	lein repl

In REPL:

Start application:

	$ (start)	

Open [http://localhost:5000/](http://localhost:5000/) in browser

Stop application:

Close browser and type following command in REPL

	$(shutdown)


## License

Copyright © 2018 Subha

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
