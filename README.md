# Ark-IoTHub
A RESTful API aiming to provide an ARK blockchain connection for IoT hardware

This piece of software is responsible for abstracting the non-essential logic from the IoT modules. Things like signing transactions and
polling for new transactions in an account. This hub device or software will need to be active on the network before IoT modules are activated so they can register with the hub and start using its functionality. I think this is an appropriate approach because other successful smart home items like Philips Hue smart bulbs also require a "Hub" to be running on the network for bulbs to be connected. The hub will abstract away all non-essential blockchain logic so the IoT developer can focus on functional code for their device.

Some basic functionality the Hub will offer IoT modules:

- Sending a message to another address
In this case the message will be put in the vendor field of the transaction that has a token value assigned when initializing the Hub
- Fetching the last transaction received on its own address

Although these may seem like simple tasks that any client should be able to accomplish itself, we cannot assume IoT will support any kind of external crypto libraries and this is stuff the developer shouldn't have to think about when writing code for hardware. This is just the beginning of functionality that we can centralize within a local network of IoT devices to simplify the process of bringing more devices onto the blockchain.

Since these hub devices will be universal and not store any state, you would be able to install them in large networks and scale them easily because all they do is handle processing of transactions for IoT-Modules (for now)

The Hub will host an API with endpoints for each of these tasks because at the very least we can assume an IoT device can connect to the internet, create a JSON structure, and send an HTTP request. 

## Learn more about the Ark IoT-Architecture 
http://gurpreetsingh.me/ProjectLedger/2017/10/16/ark-iot-infrastructure.html
