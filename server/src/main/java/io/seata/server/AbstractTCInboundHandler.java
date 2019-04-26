/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.server;

import io.seata.core.exception.AbstractExceptionHandler;
import io.seata.core.exception.TransactionException;
import io.seata.core.protocol.transaction.*;
import io.seata.core.rpc.RpcContext;

/**
 * The type Abstract tc inbound handler.
 *
 * @author sharajava
 */
public abstract class AbstractTCInboundHandler extends AbstractExceptionHandler implements TCInboundHandler {

    @Override
    public GlobalBeginResponse handle(GlobalBeginRequest request, final RpcContext rpcContext) {
        GlobalBeginResponse response = new GlobalBeginResponse();
        exceptionHandleTemplate(new Callback<GlobalBeginRequest, GlobalBeginResponse>() {
            @Override
            public void execute(GlobalBeginRequest request, GlobalBeginResponse response) throws TransactionException {
                doGlobalBegin(request, response, rpcContext);
            }
        }, request, response);
        return response;
    }

    /**
     * Do global begin.
     *
     * @param request    the request
     * @param response   the response
     * @param rpcContext the rpc context
     * @throws TransactionException the transaction exception
     */
    protected abstract void doGlobalBegin(GlobalBeginRequest request, GlobalBeginResponse response,
                                          RpcContext rpcContext) throws TransactionException;

    @Override
    public GlobalCommitResponse handle(GlobalCommitRequest request, final RpcContext rpcContext) {
        GlobalCommitResponse response = new GlobalCommitResponse();
        exceptionHandleTemplate(new Callback<GlobalCommitRequest, GlobalCommitResponse>() {
            @Override
            public void execute(GlobalCommitRequest request, GlobalCommitResponse response)
                throws TransactionException {
                doGlobalCommit(request, response, rpcContext);
            }
        }, request, response);
        return response;
    }

    /**
     * Do global commit.
     *
     * @param request    the request
     * @param response   the response
     * @param rpcContext the rpc context
     * @throws TransactionException the transaction exception
     */
    protected abstract void doGlobalCommit(GlobalCommitRequest request, GlobalCommitResponse response,
                                           RpcContext rpcContext) throws TransactionException;

    @Override
    public GlobalRollbackResponse handle(GlobalRollbackRequest request, final RpcContext rpcContext) {
        GlobalRollbackResponse response = new GlobalRollbackResponse();
        exceptionHandleTemplate(new Callback<GlobalRollbackRequest, GlobalRollbackResponse>() {
            @Override
            public void execute(GlobalRollbackRequest request, GlobalRollbackResponse response)
                throws TransactionException {
                doGlobalRollback(request, response, rpcContext);
            }
        }, request, response);
        return response;
    }

    /**
     * Do global rollback.
     *
     * @param request    the request
     * @param response   the response
     * @param rpcContext the rpc context
     * @throws TransactionException the transaction exception
     */
    protected abstract void doGlobalRollback(GlobalRollbackRequest request, GlobalRollbackResponse response,
                                             RpcContext rpcContext) throws TransactionException;

    @Override
    public BranchRegisterResponse handle(BranchRegisterRequest request, final RpcContext rpcContext) {
        BranchRegisterResponse response = new BranchRegisterResponse();
        exceptionHandleTemplate(new Callback<BranchRegisterRequest, BranchRegisterResponse>() {
            @Override
            public void execute(BranchRegisterRequest request, BranchRegisterResponse response)
                throws TransactionException {
                doBranchRegister(request, response, rpcContext);
            }
        }, request, response);
        return response;
    }

    /**
     * Do branch register.
     *
     * @param request    the request
     * @param response   the response
     * @param rpcContext the rpc context
     * @throws TransactionException the transaction exception
     */
    protected abstract void doBranchRegister(BranchRegisterRequest request, BranchRegisterResponse response,
                                             RpcContext rpcContext) throws TransactionException;

    @Override
    public BranchReportResponse handle(BranchReportRequest request, final RpcContext rpcContext) {
        BranchReportResponse response = new BranchReportResponse();
        exceptionHandleTemplate(new Callback<BranchReportRequest, BranchReportResponse>() {
            @Override
            public void execute(BranchReportRequest request, BranchReportResponse response)
                throws TransactionException {
                doBranchReport(request, response, rpcContext);
            }
        }, request, response);
        return response;
    }

    /**
     * Do branch report.
     *
     * @param request    the request
     * @param rpcContext the rpc context
     * @throws TransactionException the transaction exception
     */
    protected abstract void doBranchReport(BranchReportRequest request, BranchReportResponse response,
                                           RpcContext rpcContext)
        throws TransactionException;

    @Override
    public GlobalLockQueryResponse handle(GlobalLockQueryRequest request, final RpcContext rpcContext) {
        GlobalLockQueryResponse response = new GlobalLockQueryResponse();
        exceptionHandleTemplate(new Callback<GlobalLockQueryRequest, GlobalLockQueryResponse>() {
            @Override
            public void execute(GlobalLockQueryRequest request, GlobalLockQueryResponse response)
                throws TransactionException {
                doLockCheck(request, response, rpcContext);
            }
        }, request, response);
        return response;
    }

    /**
     * Do lock check.
     *
     * @param request    the request
     * @param response   the response
     * @param rpcContext the rpc context
     * @throws TransactionException the transaction exception
     */
    protected abstract void doLockCheck(GlobalLockQueryRequest request, GlobalLockQueryResponse response,
                                        RpcContext rpcContext) throws TransactionException;

    @Override
    public GlobalStatusResponse handle(GlobalStatusRequest request, final RpcContext rpcContext) {
        GlobalStatusResponse response = new GlobalStatusResponse();
        exceptionHandleTemplate(new Callback<GlobalStatusRequest, GlobalStatusResponse>() {
            @Override
            public void execute(GlobalStatusRequest request, GlobalStatusResponse response)
                throws TransactionException {
                doGlobalStatus(request, response, rpcContext);
            }
        }, request, response);
        return response;
    }

    /**
     * Do global status.
     *
     * @param request    the request
     * @param response   the response
     * @param rpcContext the rpc context
     * @throws TransactionException the transaction exception
     */
    protected abstract void doGlobalStatus(GlobalStatusRequest request, GlobalStatusResponse response,
                                           RpcContext rpcContext) throws TransactionException;

}
