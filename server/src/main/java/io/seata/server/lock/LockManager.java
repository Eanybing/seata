/*
 *  Copyright 1999-2018 Alibaba Group Holding Ltd.
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

package io.seata.server.lock;

import io.seata.core.exception.TransactionException;
import io.seata.server.session.BranchSession;

/**
 * The interface Lock manager.
 *
 * @author sharajava
 */
public interface LockManager {

    /**
     * Acquire lock boolean.
     *
     * @param branchSession the branch session
     * @return the boolean
     * @throws TransactionException the transaction exception
     */
    boolean acquireLock(BranchSession branchSession) throws TransactionException;

    /**
     * Is lockable boolean.
     *
     * @param transactionId the transaction id
     * @param resourceId    the resource id
     * @param lockKey       the lock key
     * @return the boolean
     * @throws TransactionException the transaction exception
     */
    boolean isLockable(long transactionId, String resourceId, String lockKey) throws TransactionException;

    /**
     * Clean all locks.
     *
     * @throws TransactionException the transaction exception
     */
    void cleanAllLocks() throws TransactionException;
}
