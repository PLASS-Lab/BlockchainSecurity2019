pragma solidity^0.5.1;

contract TestLoop {
    address owner = msg.sender;
    uint i = 2;
    uint a = 2;
    uint b = 3;
    uint c = 0;

    function testWhile() public{
        while(i > 0) {
            require(tx.origin == owner);
            i--;
        }
    }

    function testForStatement(uint amount) public {
        require(tx.origin == owner);
        for(i=0; i<10; i++) {
            a++;
            b++;
            for(uint k=0; k<5; k++) {
                msg.sender.send(amount);
                msg.sender.transfer(amount);
                require(tx.origin == owner);
                a++;
            }
        }
        c = a + b;
    }

    function testDoWhile() public {
        i = 10;
        do {
            i--;
            uint a = 10;
        } while(i > 0);
    }
}
