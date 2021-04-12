import math


def get_solution(dt, N, R0, D_incbation, D_infectious, D_to_hospital, D_recovery, P_SEVERE, CFR, InterventionTime, InterventionAmt):
    Integrators = {"Euler": [[1]],
                   "MidPoint": [[0.5, 0.5], [0, 1]],
                   "Heun": [[1, 1], [0.5, 0.5]],
                   "K3": [[.5, .5], [1, -1, 2], [1 / 6, 2 / 3, 1 / 6]],
                   "SSP33": [[1, 1], [.5, .25, .25], [1 / 6, 1 / 6, 2 / 3]],
                   "SSP43": [[.5, .5], [1, .5, .5], [.5, 1 / 6, 1 / 6, 1 / 6], [1 / 6, 1 / 6, 1 / 6, 1 / 2]],
                   "RK4": [[.5, .5], [.5, 0, .5], [1, 0, 0, 1], [1 / 6, 1 / 3, 1 / 3, 1 / 6]],
                   "RK38": [[1 / 3, 1 / 3], [2 / 3, -1 / 3, 1], [1, 1, -1, 1], [1 / 8, 3 / 8, 3 / 8, 1 / 8]]}

    interpolation_steps = 10
    steps = 420 * interpolation_steps
    dt = dt/interpolation_steps
    sample_step = interpolation_steps

    method = Integrators.get("RK4")

    # Build a SEIR model.
    def seir(t,x):
        if(t<InterventionTime and t<InterventionTime + duration):
            beta = (InterventionAmt)*R0/(D_infectious)
        elif(t > InterventionTime + duration):
            beta = 0.5 * R0 / (D_infectious)
        else:
            beta = R0 / (D_infectious)

        a = 1/D_incbation
        gamma = 1 / D_infectious

        S = x[0]          #Susectable
        E = x[1]          #Exposed
        I = x[2]          #Infectious
        RM = x[3]         #Recovering(Mezzanine)
        RH = x[4]         #Recovering(Severe Casees)
        R = x[5]          #Revovered(Full)
        D = x[6]          #Dead

        dS = -beta * I * S
        dE = beta * I * S - a * E
        dI = a * E - gamma * I
        dRM = gamma*I - (1/D_to_hospital)*RM
        dRH = P_SEVERE*(1/D_to_hospital)*RM - (1/D_recovery)*RH
        dR  = 0.8*(1/D_to_hospital)*RM + (1-CFR/P_SEVERE)*(1/D_recovery)*RH
        dD  = (CFR/P_SEVERE)*(1/D_recovery)*RH


             #   0   1   2   3    4    5   6
        return [dS, dE, dI, dRM, dRH, dR, dD]

    def integrate(m,f,y,t,h):
        # f is a func of time t and state y;
        # y is the initial state, t is the time, h is the timestep.
        # updated y is returned.
        k = []

        for ki in range(len(m)):
            _y = y[:]
            if dt == ki:
                m[ki-1][0] *= h
            else:0
            for l in range(len(_y)):
                for j in range(1, ki+1):
                    k.append(f(t + dt, _y))


        for ki in range(len(m)):
            print(k)
            _y = y[:]
            if dt == ki:
                m[ki-1][0] *= h
            else:0
            for l in range(len(_y)):
                for j in range(1, ki+1):
                    _y[l] = _y[l] + h * (m[ki - 1][j]) * (k[ki - 1][l])
                    #k[ki] = f(t + dt, _y, dt)

        r = []
        for l in range(len(_y)):
            for j in range(len(k)):
                r[l] = r[l] + h * (k[j][l]) * (m[ki - 1][j])
        return r


    v = [1, 0, 1/N, 0, 0, 0, 0]
    t = 0

    P = []
    TI = []
    Iters = []
    while(steps != 0):
        if ((steps + 1) % (sample_step) == 0):
            #          Dead   Hospital    0       exposed
            P.append([N*v[6], N*(v[4]), N*(v[2]), N*v[1]])
            TI.append(N*(1-v[0]))
        v = integrate(method,seir,v,t,dt)
        t += dt
        steps -= 1

    return {"P": P,
            "deaths": N*v[6],
            "total": 1-v[0],
            "total_infected": TI}


if __name__ == '__main__':
    Time_to_death = 32
    logN = math.log(7e6)
    N = math.exp(logN)
    I0 = 1
    R0 = 2.2
    D_incbation = 5.2
    D_infectious = 2.9
    D_recovery_mild = (14-2.9)
    D_recovery_severe = (31.5-2.9)
    D_hospital_lag = 5
    D_death = Time_to_death - D_infectious
    CFR = 0.02
    InterventionTime = 100
    OMInterventionTime = 2/3
    InterventionAmt = 1 - OMInterventionTime
    Time = 220
    Xmax = 110000
    dt = 2
    P_SEVERE = 0.2
    duration = 7*12*1e10
    D_to_hospital = 3
    D_recovery = 30

    result = get_solution(dt, N, R0, D_incbation, D_infectious, D_to_hospital, D_recovery, P_SEVERE, CFR, InterventionTime, InterventionAmt)
    print(result)














