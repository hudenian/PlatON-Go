package network.platon.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.7.5.0.
 */
public class FunctionDeclaraction extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610240806100206000396000f3fe608060405260043610610057576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806312065fe01461005c578063ab95edb114610087578063cb533b3814610109575b600080fd5b34801561006857600080fd5b5061007161018b565b6040518082815260200191505060405180910390f35b34801561009357600080fd5b506100c0600480360360208110156100aa57600080fd5b8101908080359060200190929190505050610194565b604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390f35b34801561011557600080fd5b506101426004803603602081101561012c57600080fd5b81019080803590602001909291905050506101b2565b604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390f35b60008054905090565b6000806101a0836101d0565b50503360005481915091509150915091565b6000806101be836101f2565b50503360005481915091509150915091565b6000808260008082825401925050819055503360005481915091509150915091565b600080826000808282540192505081905550336000548191509150915091509156fea165627a7a7230582040342ff7247fa7f3f4b77c72550e68717a8b6df87da6e497286e1c94e9c34d8c0029";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_UPDATE_EXTERNAL = "update_external";

    public static final String FUNC_UPDATE_PUBLIC = "update_public";

    @Deprecated
    protected FunctionDeclaraction(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected FunctionDeclaraction(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected FunctionDeclaraction(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected FunctionDeclaraction(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getBalance() {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> update_external(BigInteger amount_ex) {
        final Function function = new Function(
                FUNC_UPDATE_EXTERNAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount_ex)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> update_public(BigInteger amount_pu) {
        final Function function = new Function(
                FUNC_UPDATE_PUBLIC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount_pu)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<FunctionDeclaraction> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(FunctionDeclaraction.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<FunctionDeclaraction> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(FunctionDeclaraction.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<FunctionDeclaraction> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(FunctionDeclaraction.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<FunctionDeclaraction> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(FunctionDeclaraction.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static FunctionDeclaraction load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new FunctionDeclaraction(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static FunctionDeclaraction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new FunctionDeclaraction(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static FunctionDeclaraction load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new FunctionDeclaraction(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static FunctionDeclaraction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new FunctionDeclaraction(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}